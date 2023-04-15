package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.QuestionMapper;
import com.pzz.pojo.Question;
import com.pzz.pojo.QuestionBank;
import com.pzz.service.IQuestionBankService;
import com.pzz.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-02
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private IQuestionBankService questionBankService;

    @Override
    public int getCountByBid(Integer bid) {
        LambdaQueryWrapper<Question> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Question::getBid, bid);
        lqw.eq(Question::getStatus, 2);

        return questionMapper.selectCount(lqw);
    }

    @Override
    public List<Question> getByBid(Integer bid) {
        LambdaQueryWrapper<Question> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Question::getBid, bid);
        lqw.eq(Question::getStatus, 2);

        return questionMapper.selectList(lqw);
    }

    @Override
    public List<Question> getAdminByBid(Integer bid) {
        LambdaQueryWrapper<Question> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Question::getBid, bid);

        return questionMapper.selectList(lqw);
    }

    @Override
    public List<Question> getAdminAll(Integer status) {
        LambdaQueryWrapper<Question> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(Question::getStatus);

        if (status == 0 || status == 1 || status == 2)
            lqw.eq(Question::getStatus, status);

        return questionMapper.selectList(lqw);
    }

    @Override
    public List<Question> getByCid(int cid) {
        List<Question> questionList = new ArrayList<>();
        List<QuestionBank> questionBankList = questionBankService.getByCid(cid);

        for (QuestionBank questionBank : questionBankList) {
            List<Question> list = getByBid(questionBank.getBid());

            questionList.addAll(list);
        }

        return questionList;
    }

    @Override
    public List<Question> getAdminByCid(int cid) {
        List<Question> questionList = new ArrayList<>();
        List<QuestionBank> questionBankList = questionBankService.getByCid(cid);

        for (QuestionBank questionBank : questionBankList) {
            List<Question> list = getAdminByBid(questionBank.getBid());

            questionList.addAll(list);
        }

        return questionList;
    }
}
