package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Question;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-02
 */
public interface IQuestionService extends IService<Question> {
    int getCountByBid(Integer bid);

    List<Question> getByCid(int cid);

    List<Question> getAdminByCid(int cid);

    List<Question> getByBid(Integer bid);

    List<Question> getAdminByBid(Integer bid);

    List<Question> getAdminAll(Integer status);
}
