package com.pzz.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Company;
import com.pzz.service.ICompanyService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{pkId}")
    public JsonResult getOneById(@PathVariable int pkId) {
        Company company = companyService.getBaseMapper().selectById(pkId);

        return JsonResult.ok("company", company);
    }

    @GetMapping("/searchPage")
    public JsonResult getSearchPage(int page, int pageSize, String q, String address, String count, String type) {
        Page<Company> searchPage = companyService.getSearchPage(page, pageSize, q, address, count, type);

        return JsonResult.ok("searchPage", searchPage);
    }
}

