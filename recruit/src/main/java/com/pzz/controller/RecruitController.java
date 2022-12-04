package com.pzz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Recruit;
import com.pzz.service.IRecruitService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private IRecruitService recruitService;

    @GetMapping
    public JsonResult getAll() {
        List<Recruit> recruitList = recruitService.getBaseMapper().selectList(null);

        return JsonResult.ok("recruitList", recruitList);
    }

    @GetMapping("/list")
    public JsonResult getPage(int page, int pageSize) {
        Page<Recruit> recruitPage = recruitService.getPage(page, pageSize);

        return JsonResult.ok("recruitPage", recruitPage);
    }

    @GetMapping("/searchList")
    public JsonResult getSearchList(int page, int pageSize, String q, String city, String experience, String education, String salary) {
        Page<Recruit> searchList = recruitService.getSearchList(page, pageSize, q, city, experience, education, salary);

        return JsonResult.ok("searchList", searchList);
    }

    @GetMapping("/{pkId}")
    public JsonResult getOne(@PathVariable int pkId) {
        Recruit recruit = recruitService.getById(pkId);

        recruit.setDescription(recruit.getDescription()
                                .replaceAll(" ","&nbsp;")
                                .replaceAll("\r","<br/>"));

        return JsonResult.ok("recruit", recruit);
    }
}

