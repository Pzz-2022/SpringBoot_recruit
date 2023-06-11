package com.pzz.controller;

import com.pzz.pojo.Resume;
import com.pzz.pojo.User;
import com.pzz.service.IResumeService;
import com.pzz.service.IUserService;
import com.pzz.utils.JsonResult;
import com.pzz.utils.JwtUtil;
import com.pzz.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


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

    @Autowired
    private IResumeService resumeService;

    @PostMapping
    public JsonResult uploadFile(MultipartFile file) {
        try {
            return JsonResult.ok("url", UploadUtil.upload(file));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    @PostMapping("/resume")
    public JsonResult uploadResume(MultipartFile file, Long uid) {
        try {
            String url = UploadUtil.upload(file);

            String filename = file.getOriginalFilename();
            resumeService.save(new Resume(uid, url, filename.substring(0, filename.lastIndexOf('.'))));

            return JsonResult.ok("url", url);
        } catch (Exception e) {
            System.out.println("用户未登录或token超时.");
            e.printStackTrace();
            return JsonResult.error("用户未登录或token超时.");
        }
    }

    @PostMapping("/image")
    public JsonResult upload(MultipartFile file) {
        System.out.println("image...");
        try {
            return JsonResult.ok("url", UploadUtil.upload(file));
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

    @PostMapping("/head")
    public JsonResult uploadHead(HttpServletRequest request, MultipartFile file) {
        try {
            String url = UploadUtil.upload(file);
            Long uid = Long.valueOf(JwtUtil.parseTokenToGetUid(request.getHeader("token")));
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

    @PostMapping("/head/{hrId}")
    public JsonResult uploadHeadById(HttpServletRequest request, MultipartFile file, @PathVariable long hrId) {
        try {
            String url = UploadUtil.upload(file);
            Long uid = hrId;
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

