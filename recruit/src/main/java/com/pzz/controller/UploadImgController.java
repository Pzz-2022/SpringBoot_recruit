package com.pzz.controller;

import com.pzz.pojo.User;
import com.pzz.service.IUserService;
import com.pzz.utils.JsonResult;
import com.pzz.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * <p>
 * 文件OSS上传
 * </p>
 *
 * @author 彭政
 * @since 2022-11-29
 */
@ResponseBody
@RestController
@RequestMapping("/upload")
public class UploadImgController {
    @Autowired
    private IUserService userService;

    @PostMapping("/image")
    public JsonResult upload(MultipartFile file) {
        try {
            return JsonResult.ok("url", UploadUtil.uploadImg(file));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    @PostMapping("/onlineImage")
    public JsonResult uploadImage(MultipartFile file) {
        try {
            return JsonResult.ok("url", UploadUtil.uploadImage(file));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("文件上传失败！");
        }
    }

    @PostMapping("/head/{uid}")
    public JsonResult uploadHead(MultipartFile file, @PathVariable Long uid) {
        try {
            String url = UploadUtil.uploadImg(file);
            User user = new User();
            user.setUid(uid);
            user.setHeadPortrait(url);
            userService.updateById(user);

            return JsonResult.ok("url", url);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }
}

