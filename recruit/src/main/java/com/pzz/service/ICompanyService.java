package com.pzz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Company;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface ICompanyService extends IService<Company> {

    IPage<Company> getPage(int page, int pageSize);

    Page<Company> getSearchPage(int page, int pageSize, String q, String address, String count, String type);
}
