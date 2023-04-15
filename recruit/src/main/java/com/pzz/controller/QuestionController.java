package com.pzz.controller;


import com.pzz.pojo.Question;
import com.pzz.service.IQuestionService;
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
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @PostMapping
    private JsonResult addOne(@RequestBody Question question) {
        question.setCreateTime(DateUtil.getDate2());
        System.out.println(question);

        boolean save = questionService.save(question);

        return JsonResult.judge(save);
    }

    @GetMapping("/{qid}")
    private JsonResult getOne(@PathVariable Integer qid) {
        Question question = questionService.getById(qid);

        return JsonResult.judge("question", question);
    }

    @GetMapping("/company/{cid}")
    private JsonResult getByCid(@PathVariable Integer cid) {
        List<Question> questionList = questionService.getAdminByCid(cid);

        return JsonResult.judge("questionList", questionList);
    }

    @GetMapping("/bank/{bid}")
    private JsonResult getByBid(@PathVariable Integer bid) {
        List<Question> questionList =  questionService.getByBid(bid);

        return JsonResult.judge("questionList", questionList);
    }

    @DeleteMapping("/{qid}")
    private JsonResult deleteOne(@PathVariable Integer qid) {
        boolean b = questionService.removeById(qid);

        return JsonResult.judge(b);
    }

    @PatchMapping("/updateStatus/{qid}")
    private JsonResult updateStatus(@PathVariable Integer qid, Integer status) {
        Question question = new Question();
        question.setQid(qid);
        question.setStatus(status);

        boolean b = questionService.updateById(question);

        return JsonResult.judge(b);
    }
}

