package com.pzz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Recruit;

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

    Page<Recruit> getPage(int uid, int pageNow, int pageSize);

    Page<Recruit> getSearchList(int page, int pageSize, String q, String city, String experience, String educationStr, String salary);
}
