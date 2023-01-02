package com.pzz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.QuestionMapper;
import com.pzz.pojo.Question;
import com.pzz.service.IQuestionService;
import org.springframework.stereotype.Service;

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

}
