package com.pzz.controller;


import com.pzz.pojo.RecruitUser;
import com.pzz.service.IRecruitUserService;
import com.pzz.utils.DateUtil;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@RestController
@RequestMapping("/recruitUser")
public class RecruitUserController {
    @Autowired
    private IRecruitUserService recruitUserService;

    @GetMapping
    private JsonResult getAll() {
        List<RecruitUser> recruitUserList = recruitUserService.list();

        return JsonResult.ok("recruitUserList", recruitUserList);
    }

    @GetMapping("/applyChange/{id}")
    private JsonResult getApplyChange(@PathVariable int id) {
        List<Integer> nums = recruitUserService.getApplyChange(id);

        return JsonResult.ok("nums", nums);
    }

    @GetMapping("/applyNum/{id}")
    private JsonResult getApplyNum(@PathVariable int id) {
        int applyNum = recruitUserService.getApplyNum(id);

        return JsonResult.ok("applyNum", applyNum);
    }

    @PostMapping
    private JsonResult addOne(@RequestBody RecruitUser recruitUser) {
        recruitUser.setStatus(1);
        recruitUser.setAvgScore(0d);
        recruitUser.setTime(DateUtil.getDate2());

        boolean b = recruitUserService.save(recruitUser);

        return JsonResult.judge(b);
    }

    @GetMapping("/{uid}")
    private JsonResult getOne(@PathVariable Integer uid, Integer rid) {
        System.out.println(uid);
        System.out.println(rid);
        RecruitUser recruit = recruitUserService.selectOne(uid, rid);

        return recruit != null ? JsonResult.ok("recruit", recruit) : JsonResult.error("还未申请。");
    }

    @GetMapping("/hireAttract/{hrId}")
    private JsonResult getByHrId(@PathVariable Integer hrId, Integer pageNow, Integer pageSize) {
        List<RecruitUser> recruitUserList = recruitUserService.selectByHrId(hrId, pageNow, pageSize);
        Integer total = recruitUserService.selectByHrIdTotal(hrId);

        JsonResult jsonResult = JsonResult.ok("recruitUserList", recruitUserList);
        jsonResult.addData("total", total);
        return jsonResult;
    }

    @PatchMapping("/{pkId}")
    private JsonResult updateById(@PathVariable Integer pkId, Integer status) {
        System.out.println(status);
        RecruitUser recruitUser = new RecruitUser(pkId, status);

        boolean b = recruitUserService.updateById(recruitUser);
        return JsonResult.judge(b);
    }
}

