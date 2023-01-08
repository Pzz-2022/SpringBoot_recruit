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

    @PostMapping
    private JsonResult addOne(@RequestBody RecruitUser recruitUser) {
        recruitUser.setStatus(1);
        recruitUser.setAvgScore(0d);
        recruitUser.setTime(DateUtil.getDate2());

        boolean b = recruitUserService.save(recruitUser);

        return JsonResult.judge(b);
    }

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

    @GetMapping("/{uid}")
    private JsonResult getOne(@PathVariable Integer uid, Integer rid) {
        System.out.println(uid);
        System.out.println(rid);
        RecruitUser recruitUser = recruitUserService.selectOne(uid, rid);

        return recruitUser != null ? JsonResult.ok("recruitUser", recruitUser) : JsonResult.error("还未申请。");
    }

    @GetMapping("/hireAttract/{hrId}")
    private JsonResult getByHrId(@PathVariable Integer hrId, Integer pageNow, Integer pageSize) {
        List<RecruitUser> recruitUserList = recruitUserService.selectByHrId(hrId, pageNow, pageSize);
        Integer total = recruitUserService.selectByHrIdTotal(hrId);

        JsonResult jsonResult = JsonResult.ok("recruitUserList", recruitUserList);
        jsonResult.addData("total", total);
        return jsonResult;
    }

    // 查询正在申请的职位
    @GetMapping("/selectAllRecruitUserByUid/{uid}")
    private JsonResult selectAllRecruitUserByUid(@PathVariable Integer uid) {
        List<RecruitUser> recruitUserList = recruitUserService.selectAllByUid(uid);

        return JsonResult.ok("recruitUserList", recruitUserList);
    }

    @PatchMapping("/{pkId}")
    private JsonResult updateById(@PathVariable Integer pkId, Integer status) {
        System.out.println(status);
        RecruitUser recruitUser = new RecruitUser(pkId, status);

        boolean b = recruitUserService.updateById(recruitUser);
        return JsonResult.judge(b);
    }

    @PatchMapping("/updateBid/{pkId}")
    private JsonResult updateBidById(@PathVariable Integer pkId, Integer bid) {
        RecruitUser recruitUser = new RecruitUser(pkId);
        recruitUser.setBid(bid);

        boolean b = recruitUserService.updateById(recruitUser);
        return JsonResult.judge(b);
    }

    @PatchMapping("/updateScore/{pkId}")
    private JsonResult updateScoreById(@PathVariable Integer pkId, Double score) {
        RecruitUser recruitUser = new RecruitUser(pkId);
        recruitUser.setAvgScore(score);

        boolean b = recruitUserService.updateById(recruitUser);
        return JsonResult.judge(b);
    }
}

