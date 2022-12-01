package com.pzz.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Company;
import com.pzz.pojo.Recruit;
import com.pzz.service.ICompanyService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @GetMapping
    private JsonResult getAll() {
        List<Company> companyList = companyService.getBaseMapper().selectList(null);

        return JsonResult.ok("companyList", companyList);
    }

    @GetMapping("/list")
    public JsonResult getPage(int page, int pageSize) {
        IPage<Company> companyList = companyService.getPage(page, pageSize);

        return JsonResult.ok("companyList", companyList);
    }
}

