package com.pzz.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.RecordUserRecruitMapper;
import com.pzz.pojo.RecordUserRecruit;
import com.pzz.service.IRecordUserRecruitService;
import com.pzz.utils.LRUCache;
import com.pzz.utils.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-04
 */
@Service
public class RecordUserRecruitServiceImpl extends ServiceImpl<RecordUserRecruitMapper, RecordUserRecruit> implements IRecordUserRecruitService {
    private static final int page = 1;
    private static final int pageSize = 6;

    @Autowired
    private RecordUserRecruitMapper recordUserRecruitMapper;

    @Override
    public Page<RecordUserRecruit> selectRecordByUid(HttpServletRequest request, Long uid) {
        // 设置分页
        Page<RecordUserRecruit> recordPage = new Page(page, pageSize);

        // 设置时间倒序、分人查询条件
        LambdaQueryWrapper<RecordUserRecruit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(RecordUserRecruit::getUid, uid);
        lqw.orderByDesc(RecordUserRecruit::getCreateTime);

        return recordUserRecruitMapper.selectPage(recordPage, lqw);
    }


    @Override
    public JSONObject selectJSONRecordByUid(HttpServletRequest request, Long uid) {
        System.out.println();
        System.out.println(request.getSession().getAttribute("lruCache"));
        System.out.println();

        if (request.getSession().getAttribute("lruCache") == null) {
            // 设置分页
            Page<RecordUserRecruit> recordPage = new Page(page, pageSize);

            // 设置时间倒序、分人查询条件
            LambdaQueryWrapper<RecordUserRecruit> lqw = new LambdaQueryWrapper<>();
            lqw.eq(RecordUserRecruit::getUid, uid);
            lqw.orderByDesc(RecordUserRecruit::getCreateTime);

            Page<RecordUserRecruit> recordUserRecruitPage = recordUserRecruitMapper.selectPage(recordPage, lqw);
//            request.setAttribute("recordUserRecruitPage", recordUserRecruitPage);

            LRUCache<Integer, RecordUserRecruit> lruCache = new LRUCache<>(6);
            for (RecordUserRecruit record : recordUserRecruitPage.getRecords()) {
                lruCache.put(record.getRecruitId(), record);
            }
            request.getSession().setAttribute("lruCache", lruCache);
        }

        JSONObject recordUserRecruitPage = new JSONObject();
        JSONArray records = new JSONArray();

        LRUCache<Integer, RecordUserRecruit> lruCache = (LRUCache<Integer, RecordUserRecruit>) request.getSession().getAttribute("lruCache");

        Entry<Integer, RecordUserRecruit> head = lruCache.head;
        for (int i = 0; i < lruCache.size; i++) {
            head = head.next;
            System.out.println(head.value);
            records.add(head.value);
        }
        recordUserRecruitPage.put("records", records);
        recordUserRecruitPage.put("total", records.size());

//        return (Page<RecordUserRecruit>) request.getSession().getAttribute("recordUserRecruitPage");
        return recordUserRecruitPage;
    }

    @Override
    public void updateRecord(HttpServletRequest request) {
        LRUCache<Integer, RecordUserRecruit> lruCache = (LRUCache<Integer, RecordUserRecruit>) request.getSession().getAttribute("lruCache");

        Entry<Integer, RecordUserRecruit> head = lruCache.head;
        for (int i = 0; i < lruCache.size; i++) {
            head = head.next;

            LambdaQueryWrapper<RecordUserRecruit> lqw = new LambdaQueryWrapper<>();
            lqw.eq(RecordUserRecruit::getUid, head.value.getUid());
            lqw.eq(RecordUserRecruit::getRecruitId, head.key);
            this.remove(lqw);

            this.save(head.value);
            System.out.println(head.value);
        }
    }
}
