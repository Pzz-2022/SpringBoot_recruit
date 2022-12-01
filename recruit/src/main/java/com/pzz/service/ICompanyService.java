package com.pzz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pzz.pojo.Company;
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
public interface ICompanyService extends IService<Company> {

    IPage<Company> getPage(int page, int pageSize);

}
