package com.pzz.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

// 文件OSS上传
public class UploadUtil {
    // 域名(开头需要https://，结尾要/)
    public static final String ALI_DOMAIN = "https://springboot-recruit.oss-cn-guangzhou.aliyuncs.com/";
    private static final String path = "D:\\Software\\FileRecv\\Recruit\\";
    private static final String resultPath = "http://localhost:8088/static/";

    // 上传到阿里云OSS远程仓库
    public static String uploadImage(MultipartFile file) throws Exception {
        //生成的文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(originalFilename);
        String fileName = uuid + ext;
        //地域节点(开头需要http://)
        String endpoint = "http://oss-cn-guangzhou.aliyuncs.com/";
        String accessKeyId = "LTAI5tBadZU4m5hbV2NPdTjF";
        String accessKeySecret = "ojlcNjTe9NQphFksL5V8J6q5A1ohwD";
        //OSS客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建上传文件的元信息，可以通过文件元信息设置HTTP header(设置了才能通过返回的链接直接访问)。
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
        objectMetadata.setContentDisposition("inline");

        ossClient.putObject(
                "springboot-recruit", //仓库名
                fileName, //文件名
                new ByteArrayInputStream(file.getBytes()),
                objectMetadata
        );
        // 释放资源
        ossClient.shutdown();

        // 将文件URL返回
        return ALI_DOMAIN + fileName;
    }

    // 上传在本地的仓库
    public static String upload(MultipartFile file) throws Exception {
        // 图片校验（图片是否为空,图片大小，上传的是不是图片、图片类型（例如只能上传png）等等）
        // 非空校验
        if (file.isEmpty()) {
            return "上传失败";
        }
        //获取原来的文件名和后缀
        String originalFilename = file.getOriginalFilename();
//        String ext = "." + FilenameUtils.getExtension(orgFileName); --需要导依赖
        String ext = originalFilename.substring(originalFilename.lastIndexOf('.'));
        //生成一个新的文件名（以防有重复的名字存在导致被覆盖）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //拼接图片上传的路径 url+图片名
        String newName = uuid + ext;

        // 返回路径是虚拟的 保存路径是真实的盘符
        String filepath = path + newName;
        try {
            file.transferTo(new File(filepath));

            // 设置返回路径
            return resultPath + newName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
