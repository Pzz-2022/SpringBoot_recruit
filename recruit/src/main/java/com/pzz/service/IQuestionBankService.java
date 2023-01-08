package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.QuestionBank;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-02
 */
public interface IQuestionBankService extends IService<QuestionBank> {

    List<QuestionBank> getByCid(Integer cid);

    int updateQuestionCount(Integer bid);
}
