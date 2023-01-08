package com.pzz.controller;


import com.pzz.pojo.QuestionBank;
import com.pzz.service.IQuestionBankService;
import com.pzz.utils.DateUtil;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2023-01-02
 */
@RestController
@RequestMapping("/questionBank")
public class QuestionBankController {
    @Autowired
    private IQuestionBankService questionBankService;

    @PostMapping
    private JsonResult addOne(@RequestBody QuestionBank questionBank) {
        questionBank.setCreateTime(DateUtil.getDate2());

        boolean save = questionBankService.save(questionBank);

        return JsonResult.judge(save);
    }

    @GetMapping("/{bid}")
    private JsonResult getOne(@PathVariable Integer bid) {
        questionBankService.updateQuestionCount(bid);

        QuestionBank questionBank = questionBankService.getById(bid);

        return JsonResult.ok("questionBank", questionBank);
    }

    @GetMapping("/company/{cid}")
    private JsonResult getByCid(@PathVariable Integer cid) {
        List<QuestionBank> questionBankList = questionBankService.getByCid(cid);

        return JsonResult.ok("questionBankList", questionBankList);
    }
}

