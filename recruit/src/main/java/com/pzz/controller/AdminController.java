package com.pzz.controller;


import com.pzz.pojo.Admin;
import com.pzz.pojo.Question;
import com.pzz.service.IAdminService;
import com.pzz.service.IQuestionService;
import com.pzz.utils.JsonResult;
import com.pzz.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2023-01-10
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @Autowired
    private IQuestionService questionService;

    @PostMapping("/login")
    public JsonResult login(HttpServletRequest request, @RequestBody Admin admin) {
        System.out.println(admin);
        admin = adminService.login(admin);
        System.out.println(admin);

        if (admin == null)
            return JsonResult.error();

        String tokenStr = JwtUtil.createToken(Long.valueOf(admin.getAccount()), admin.getName());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("token", tokenStr);

        HttpSession session = request.getSession();
        session.setAttribute("token", tokenStr);

        return JsonResult.ok("token", tokenStr);
    }

    @GetMapping("/userChange/{day}")
    public JsonResult userChange(@PathVariable Integer day) {
        List<Number> nums = adminService.userChange(day);

        return JsonResult.ok("nums", nums);
    }

    @GetMapping("/companyChange/{day}")
    public JsonResult companyChange(@PathVariable Integer day) {
        List<Number> nums = adminService.companyChange(day);

        System.out.println("nums = " + nums);

        return JsonResult.ok("nums", nums);
    }

    @GetMapping("/question/{status}")
    public JsonResult getQuestion(@PathVariable Integer status) {
        List<Question> questionList = questionService.getAdminAll(status);

        return JsonResult.ok("questionList", questionList);
    }
}

