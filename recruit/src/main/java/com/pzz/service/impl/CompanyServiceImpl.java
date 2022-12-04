package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.mapper.CompanyMapper;
import com.pzz.pojo.Company;
import com.pzz.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Override
    public IPage<Company> getPage(int page, int pageSize) {
        Page<Company> rowPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Company> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(Company::getJob);

        return baseMapper.selectPage(rowPage, lqw);
    }

    @Override
    public Page<Company> getSearchPage(int page, int pageSize, String q, String address, String count, String type) {
        Page<Company> rowPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Company> lqw = new LambdaQueryWrapper<>();
        lqw.like(Company::getName, q)
                .like(Company::getAddress, address)
                .like(Company::getCount, count)
                .like(Company::getType, type);

        return baseMapper.selectPage(rowPage, lqw);
    }
}
