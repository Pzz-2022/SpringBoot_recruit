package com.pzz.controller;


import com.alibaba.fastjson.JSONObject;
import com.pzz.service.IRecordUserRecruitService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-12-04
 */
@RestController
@RequestMapping("/recordUserRecruit")
public class RecordUserRecruitController {
    @Autowired
    private IRecordUserRecruitService recordUserRecruitService;

    @GetMapping("/{uid}")
    public JsonResult getRecordByUid(HttpServletRequest request, @PathVariable Long uid) {
//        Page<RecordUserRecruit> recordUserRecruitPage = recordUserRecruitService.selectRecordByUid(request, uid);
        JSONObject recordUserRecruitPage = recordUserRecruitService.selectJSONRecordByUid(request, uid);

        return JsonResult.ok("recordUserRecruitPage", recordUserRecruitPage);
    }

    @PatchMapping
    public JsonResult updateRecord(HttpServletRequest request) {
        recordUserRecruitService.updateRecord(request);
        return JsonResult.ok();
    }
}

