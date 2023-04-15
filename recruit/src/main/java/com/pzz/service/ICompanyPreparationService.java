package com.pzz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.CompanyPreparation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
public interface ICompanyPreparationService extends IService<CompanyPreparation> {

    Page<CompanyPreparation> searchPage(Integer page, Integer size);

    void updateCompany(CompanyPreparation companyPreparation);
}
