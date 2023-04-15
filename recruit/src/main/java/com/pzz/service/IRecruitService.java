package com.pzz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Recruit;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface IRecruitService extends IService<Recruit> {

    Page<Recruit> getPage(int page, int pageSize);

    Page<Recruit> getPage(int hrId, int pageNow, int pageSize);

    List<Recruit> getPage(int hrId);

    Page<Recruit> getSearchList(int page, int pageSize, String q, String city, String experience, String educationStr, String salary);

    int getPagePlus(Integer hrId);
}
