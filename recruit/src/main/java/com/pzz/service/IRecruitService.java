package com.pzz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Recruit;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
