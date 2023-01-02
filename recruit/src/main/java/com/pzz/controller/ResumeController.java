package com.pzz.controller;


import com.pzz.pojo.Resume;
import com.pzz.service.IResumeService;
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
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private IResumeService resumeService;

    @GetMapping("/{uid}")
    private JsonResult getByUid(@PathVariable Integer uid) {
        List<Resume> resumeList = resumeService.getByUid(uid);

        return JsonResult.judge("resumeList", resumeList);
    }

    @DeleteMapping("/{pkId}")
    private JsonResult deleteById(@PathVariable Integer pkId) {
        boolean b = resumeService.removeById(pkId);

        return JsonResult.judge(b);
    }
}

