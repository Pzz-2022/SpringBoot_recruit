package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.RecordUserRecruitMapper;
import com.pzz.pojo.RecordUserRecruit;
import com.pzz.service.IRecordUserRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page<RecordUserRecruit> selectRecordByUid(Long uid) {
        // 设置分页
        Page<RecordUserRecruit> recordPage = new Page(page, pageSize);

        // 设置时间倒序、分人查询条件
        LambdaQueryWrapper<RecordUserRecruit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(RecordUserRecruit::getUid, uid);
        lqw.orderByDesc(RecordUserRecruit::getCreateTime);

        return recordUserRecruitMapper.selectPage(recordPage, lqw);
    }
}
