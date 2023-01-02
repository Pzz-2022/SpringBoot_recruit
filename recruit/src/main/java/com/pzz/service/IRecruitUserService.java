package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Recruit;
import com.pzz.pojo.RecruitUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface IRecruitUserService extends IService<RecruitUser> {

    List<Integer> getApplyChange(int rid);

    int getApplyNum(int rid);

    RecruitUser selectOne(Integer uid, Integer rid);

    List<RecruitUser> selectByHrId(Integer hrId, Integer pageNow, Integer pageSize);

    Integer selectByHrIdTotal(Integer hrId);
}
