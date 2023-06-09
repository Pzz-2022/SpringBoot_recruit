package com.pzz.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pzz.pojo.User;
import com.pzz.service.IUserService;
import com.pzz.utils.JsonResult;
import com.pzz.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @PostMapping("/login")
    public JsonResult applyLogin(HttpServletRequest request, @RequestBody Map<String, User> para) throws JsonProcessingException {
        User user = para.get("data");
        System.out.println(user);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getPhone, user.getPhone());

        User resultUser = userService.getOne(lqw);

        if (resultUser.getPassword().equals(user.getPassword())) {
            String tokenStr = JwtUtil.createToken(resultUser.getUid(), resultUser.getName());

            HttpSession session = request.getSession();
            session.setAttribute("token", tokenStr);

            return JsonResult.ok("token", tokenStr);
        } else
            return JsonResult.error();
    }

    @PostMapping("/hr_login")
    public JsonResult hrLogin(@RequestBody Map<String, User> para) throws JsonProcessingException {
        User user = para.get("data");
        System.out.println(user);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getPhone, user.getPhone());
        lqw.ne(User::getCompanyId, 0);

        User result = userService.getOne(lqw);

        if (result.getPassword().equals(user.getPassword())) {
            String tokenStr = JwtUtil.createToken(user.getUid(), user.getName());

            return JsonResult.ok("token", tokenStr);
        } else
            return JsonResult.error();
    }

    @PostMapping("/register")
    public JsonResult applyRegister(@RequestBody User user) {
        System.out.println(user);

        String uid = userService.applyRegister(user);
        if (uid.equals(""))
            return JsonResult.error();
        return JsonResult.ok("uid", uid);
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody User user) {
        System.out.println(user);

        return userService.updateById(user) ? JsonResult.ok() : JsonResult.error();
    }

    @GetMapping("/{phone}")
    public JsonResult getUser(@PathVariable Long phone) {
        System.out.println(phone);

        User user = userService.getByPhone(phone);
        return JsonResult.ok("user", user);
    }

    @GetMapping("/getOne/{uid}")
    public JsonResult getOne(@PathVariable Integer uid) {
        User user = userService.getById(uid);
        return JsonResult.ok("user", user);
    }

    @GetMapping("/list")
    public JsonResult getList(int page, int pageSize) {
        Page<User> rowPage = new Page<>(page, pageSize);

        Page<User> userPage = userService.getBaseMapper().selectPage(rowPage, null);

        return JsonResult.ok("userPage", userPage);
    }

    @PostMapping("/update/modify_personal_info")
    public JsonResult updateCandidate(@RequestBody User user) {
        System.out.println(user);
        return userService.updateById(user) ? JsonResult.ok() : JsonResult.error();
    }


    @DeleteMapping("/{uid}")
    public JsonResult deleteOne(@PathVariable int uid) {
        boolean b = userService.removeById(uid);

        return JsonResult.judge(b);
    }
}

