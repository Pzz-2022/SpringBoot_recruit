package com.pzz.controller;


import com.pzz.pojo.Classify;
import com.pzz.service.IClassifyService;
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
 * @since 2022-12-27
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private IClassifyService classifyService;

    @PostMapping
    public JsonResult addOne(Classify classify) {
        boolean b = classifyService.save(classify);

        return JsonResult.judge(b);
    }

    @GetMapping
    public JsonResult getAll() {
        List<Classify> classifyList = classifyService.selectAll();

        return JsonResult.ok("classifyList", classifyList);
    }

    @GetMapping("/{cid}")
    private JsonResult getOne(@PathVariable Integer cid) {
        Classify classify = classifyService.getById(cid);

        return JsonResult.ok("classify", classify);
    }
}

