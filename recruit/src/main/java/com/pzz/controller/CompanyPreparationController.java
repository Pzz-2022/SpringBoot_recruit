package com.pzz.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Company;
import com.pzz.pojo.CompanyPreparation;
import com.pzz.service.ICompanyPreparationService;
import com.pzz.service.ICompanyService;
import com.pzz.utils.DateUtil;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
@RestController
@RequestMapping("/companyPreparation")
public class CompanyPreparationController {
    @Autowired
    private ICompanyPreparationService companyPreparationService;

    @PostMapping
    public JsonResult addOne(@RequestBody CompanyPreparation companyPreparation) {
        companyPreparation.setCreateTime(DateUtil.getDate2());

        boolean save = companyPreparationService.save(companyPreparation);

        return save ? JsonResult.ok("companyPreparation", companyPreparation) : JsonResult.error();
    }

    @GetMapping
    public JsonResult getAll() {
        List<CompanyPreparation> companyPreparationList = companyPreparationService.list();

        return JsonResult.ok("companyPreparationList", companyPreparationList);
    }

    @GetMapping("/{pkId}")
    public JsonResult getOne(@PathVariable Integer pkId) {
        CompanyPreparation companyPreparation = companyPreparationService.getById(pkId);

        return JsonResult.judge("companyPreparation", companyPreparation);
    }

    @GetMapping("/searchPage")
    public JsonResult searchPage(Integer page, Integer size) {
        Page<CompanyPreparation> companyPreparationPage = companyPreparationService.searchPage(page, size);

        return JsonResult.ok("companyPreparationPage", companyPreparationPage);
    }

    @PutMapping
    public JsonResult updateByPut(@RequestBody CompanyPreparation companyPreparation) {
        boolean b = companyPreparationService.updateById(companyPreparation);

        if (companyPreparation.getStatus() != null)
            if (companyPreparation.getStatus() == 2 || companyPreparation.getStatus() == 0) {
                companyPreparationService.updateCompany(companyPreparation);
            }

        return JsonResult.judge(b);
    }
}

