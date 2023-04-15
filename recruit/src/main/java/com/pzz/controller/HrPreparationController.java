package com.pzz.controller;


import com.pzz.pojo.HrPreparation;
import com.pzz.service.IHrPreparationService;
import com.pzz.utils.DateUtil;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
@RestController
@RequestMapping("/hrPreparation")
public class HrPreparationController {
    @Autowired
    private IHrPreparationService hrPreparationService;

    @PostMapping
    public JsonResult addOne(@RequestBody HrPreparation hrPreparation) {
        hrPreparation.setCreateTime(DateUtil.getDate2());

        boolean save = hrPreparationService.save(hrPreparation);

        return JsonResult.judge(save);
    }

    @GetMapping
    public JsonResult getAll() {
        List<HrPreparation> hrPreparationList = hrPreparationService.list();

        return JsonResult.judge("hrPreparationList", hrPreparationList);
    }

    @GetMapping("/{pkId}")
    public JsonResult getOne(@PathVariable Integer pkId) {
        HrPreparation hrPreparation = hrPreparationService.getById(pkId);

        return JsonResult.judge("hrPreparation", hrPreparation);
    }

    @GetMapping("/page")
    public JsonResult getPage(Integer page, Integer size) {
        IPage<HrPreparation> hrPreparationPage = hrPreparationService.getPage(page, size);

        return JsonResult.judge("hrPreparationPage", hrPreparationPage);
    }

    @PutMapping
    public JsonResult updateByPut(@RequestBody HrPreparation hrPreparation) {
        boolean b = hrPreparationService.updateById(hrPreparation);

        if (hrPreparation.getStatus() == 2 || hrPreparation.getStatus() == 0) {
            hrPreparationService.updateUser(hrPreparation);
        }

        return JsonResult.judge(b);
    }
}

