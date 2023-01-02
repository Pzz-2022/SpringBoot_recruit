package com.pzz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzz.pojo.RecruitUser;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface RecruitUserMapper extends BaseMapper<RecruitUser> {

    int selectApplyByDay(int rid, String date);

    int selectApplyNum(int rid);

    List<RecruitUser> selectByHrId(Integer hrId, Integer pageBegin, Integer pageSize);

    Integer selectByHrIdTotal(Integer hrId);
}
