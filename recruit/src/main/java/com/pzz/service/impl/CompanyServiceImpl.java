package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Company;
import com.pzz.mapper.CompanyMapper;
import com.pzz.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Page<Company> companyPage = baseMapper.selectPage(rowPage, null);

        return companyPage;
    }
}
