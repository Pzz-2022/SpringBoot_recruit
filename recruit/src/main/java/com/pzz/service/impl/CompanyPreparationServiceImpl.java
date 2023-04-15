package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.CompanyPreparationMapper;
import com.pzz.pojo.Company;
import com.pzz.pojo.CompanyPreparation;
import com.pzz.service.ICompanyPreparationService;
import com.pzz.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
@Service
public class CompanyPreparationServiceImpl extends ServiceImpl<CompanyPreparationMapper, CompanyPreparation> implements ICompanyPreparationService {
    @Autowired
    private CompanyPreparationMapper companyPreparationMapper;
    @Autowired
    private ICompanyService companyService;


    @Override
    public Page<CompanyPreparation> searchPage(Integer page, Integer size) {
        LambdaQueryWrapper<CompanyPreparation> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(CompanyPreparation::getCreateTime);
        lqw.eq(CompanyPreparation::getStatus, 1);

        return companyPreparationMapper.selectPage(new Page<>(page, size), lqw);
    }

    @Override
    public void updateCompany(CompanyPreparation companyPreparation) {
        companyPreparation = companyPreparationMapper.selectById(companyPreparation.getPkId());

        if (companyPreparation.getCid() != null) {
            if (companyPreparation.getStatus() == 0) {
                companyService.removeById(companyPreparation.getCid());
            }
        } else if (companyPreparation.getStatus() == 2) {
            Company company = new Company();
            if (companyPreparation.getName() != null && !companyPreparation.getName().equals(""))
                company.setName(companyPreparation.getName());
            if (companyPreparation.getLogo() != null && !companyPreparation.getLogo().equals(""))
                company.setLogo(companyPreparation.getLogo());
            if (companyPreparation.getCreateTime() != null && !companyPreparation.getCreateTime().equals(""))
                company.setTimeCreate(companyPreparation.getCreateTime());

            companyService.save(company);

            companyPreparation.setCid(company.getPkId());
            companyPreparationMapper.updateById(companyPreparation);
        }
    }


}
