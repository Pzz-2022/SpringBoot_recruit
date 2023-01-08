package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.QuestionBankMapper;
import com.pzz.pojo.QuestionBank;
import com.pzz.service.IQuestionBankService;
import com.pzz.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements IQuestionBankService {
    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Autowired
    private IQuestionService questionService;

    @Override
    public List<QuestionBank> getByCid(Integer cid) {
        LambdaQueryWrapper<QuestionBank> lqw = new LambdaQueryWrapper<>();
        lqw.eq(QuestionBank::getCompanyId, cid);
        lqw.orderByAsc(QuestionBank::getCreateTime);

        List<QuestionBank> questionBankList = questionBankMapper.selectList(lqw);
        for (QuestionBank questionBank : questionBankList) {
            int count = updateQuestionCount(questionBank.getBid());
            questionBank.setQuestionCount(count);
        }

        return questionBankList;
    }

    @Override
    public int updateQuestionCount(Integer bid) {
        int countByBid = questionService.getCountByBid(bid);

        QuestionBank questionBank = new QuestionBank();
        questionBank.setBid(bid);
        questionBank.setQuestionCount(countByBid);

        questionBankMapper.updateById(questionBank);
        return countByBid;
    }
}
