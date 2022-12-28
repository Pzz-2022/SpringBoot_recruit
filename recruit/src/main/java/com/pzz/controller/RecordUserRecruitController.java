package com.pzz.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.RecordUserRecruit;
import com.pzz.pojo.Recruit;
import com.pzz.service.IRecordUserRecruitService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public JsonResult getRecordByUid(@PathVariable Long uid) {
        Page<RecordUserRecruit> recordUserRecruitPage = recordUserRecruitService.selectRecordByUid(uid);

        return JsonResult.ok("recordUserRecruitPage", recordUserRecruitPage);
    }

}

