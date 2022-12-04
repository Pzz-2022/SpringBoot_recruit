package com.pzz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzz.pojo.Recruit;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface RecruitMapper extends BaseMapper<Recruit> {

    List<Recruit> selectSearchList(int index, int pageSize, String q, String city, String experience, String education, int salaryStart, int salaryEnd);

    int selectSearchListTotal(String q, String city, String experience, String education, int salaryStart, int salaryEnd);

    List<Recruit> selectAll();
}
