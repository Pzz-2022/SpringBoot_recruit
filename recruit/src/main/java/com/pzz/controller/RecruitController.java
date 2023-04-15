package com.pzz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.RecordUserRecruit;
import com.pzz.pojo.Recruit;
import com.pzz.service.IHrInfoService;
import com.pzz.service.IRecordUserRecruitService;
import com.pzz.service.IRecruitService;
import com.pzz.utils.JsonResult;
import com.pzz.utils.JwtUtil;
import com.pzz.utils.LRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private IRecruitService recruitService;

    @Autowired
    private IRecordUserRecruitService recordUserRecruitService;

    @Autowired
    private IHrInfoService hrInfoService;

    @GetMapping
    public JsonResult getAll() {
        List<Recruit> recruitList = recruitService.getBaseMapper().selectList(null);

        return JsonResult.ok("recruitList", recruitList);
    }

    @GetMapping("/list")
    public JsonResult getPage(int page, int pageSize) {
        Page<Recruit> recruitPage = recruitService.getPage(page, pageSize);

        System.out.println(recruitPage);
        return JsonResult.ok("recruitPage", recruitPage);
    }

    @GetMapping("/list/{hrId}")
    public JsonResult getPage( @PathVariable int hrId, int pageNow, int pageSize) {
        Page<Recruit> recruitPage = recruitService.getPage(hrId, pageNow, pageSize);

        return JsonResult.ok("recruitPage", recruitPage);
    }

    @GetMapping("/searchList")
    public JsonResult getSearchList(int page, int pageSize, String q, String city, String experience, String education, String salary) {
        Page<Recruit> searchList = recruitService.getSearchList(page, pageSize, q, city, experience, education, salary);

        System.out.println(searchList);
        return JsonResult.ok("searchList", searchList);
    }

    @GetMapping("/{pkId}")
    public JsonResult getOne(HttpServletRequest request, @PathVariable int pkId) {
        // 获取数据
        Recruit recruit = recruitService.getById(pkId);
        System.out.println(pkId);

        if (recruit != null) {
            try {
                // 添加浏览记录
                String token = request.getHeader("token");
                if (token == null || token.equals("")){
                    throw new Exception("该用户未登录。");
                }
                Integer uid = JwtUtil.parseTokenToGetUid(token);
                System.out.print("uid:");
                System.out.println(uid);
                if (request.getSession().getAttribute("lruCache") == null) {
                    System.out.println(1);
                    recordUserRecruitService.selectJSONRecordByUid(request, Long.valueOf(uid));
                }
                RecordUserRecruit recordUserRecruit = new RecordUserRecruit(uid, pkId);

//                recordUserRecruitService.save(recordUserRecruit);
                LRUCache<Integer, RecordUserRecruit> lruCache = (LRUCache<Integer, RecordUserRecruit>) request.getSession().getAttribute("lruCache");

                System.out.println(lruCache);
                lruCache.put(pkId, new RecordUserRecruit(uid, pkId));
                System.out.println(lruCache);
                request.getSession().setAttribute("lruCache", lruCache);
            } catch (Exception e) {
                System.out.println("该用户未登录。");
            }

            // 处理数据
            recruit.setDescription(recruit.getDescription()
                    .replaceAll(" ","&nbsp;")
                    .replaceAll("\r","<br/>"));
            return JsonResult.ok("recruit", recruit);
        }
        return JsonResult.error("为查询到招聘信息！");
    }

    @GetMapping("/search/{pkId}")
    public JsonResult getSearchOne(@PathVariable int pkId) {
        // 获取数据
        Recruit recruit = recruitService.getById(pkId);
        System.out.println(pkId);

        if (recruit != null) {
            return JsonResult.ok("recruit", recruit);
        }
        return JsonResult.error("为查询到招聘信息！");
    }

    @GetMapping("/select/{pkId}")
    public JsonResult getOnePlus(@PathVariable int pkId) {
        // 获取数据
        Recruit recruit = recruitService.getById(pkId);

        if (recruit != null) {
            // 处理数据
            recruit.setDescription(recruit.getDescription()
                    .replaceAll(" ","&nbsp;")
                    .replaceAll("\r","<br/>"));
            return JsonResult.ok("recruit", recruit);
        }
        return JsonResult.error("为查询到招聘信息！");
    }

    @PostMapping
    public JsonResult addOne(@RequestBody Recruit recruit) {
        boolean b = recruitService.save(recruit);

        return JsonResult.judge(b);
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteOne(@PathVariable int id) {
        boolean b = recruitService.removeById(id);

        return JsonResult.judge(b);
    }

    @PatchMapping
    private JsonResult updateOne(@RequestBody Recruit recruit) {
        boolean b = recruitService.updateById(recruit);

        return JsonResult.judge(b);
    }

    @PatchMapping("/updateStatus/{rid}")
    private JsonResult updateStatus(@PathVariable int rid) {
        Recruit recruit = recruitService.getById(rid);

        recruit.setStatus(recruit.getStatus()+1);
        recruitService.updateById(recruit);

        return JsonResult.ok();
    }
}

