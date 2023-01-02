package com.pzz.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pzz.pojo.HrInfo;
import com.pzz.service.IHrInfoService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/hrInfo")
public class HrInfoController {
    @Autowired
    private IHrInfoService hrInfoService;

    @GetMapping("/{hrId}")
    public JsonResult getHrInfo(@PathVariable Integer hrId) {
        LambdaQueryWrapper<HrInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(HrInfo::getHrId, hrId);

        HrInfo hrInfo = hrInfoService.getOne(lqw);

        if (hrInfo != null)
            return JsonResult.ok("hrInfo", hrInfo);
        else
            return JsonResult.error("查询失败！");
    }

    @PatchMapping
    private JsonResult updateHrInfo(@RequestBody Map<String, HrInfo> hrInfo) {
        System.out.println(hrInfo);
        boolean b = hrInfoService.updateById(hrInfo.get("hrInfo"));

        return JsonResult.judge(b);
    }
}

