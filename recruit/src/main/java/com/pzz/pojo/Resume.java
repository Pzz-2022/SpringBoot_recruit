package com.pzz.pojo;

import lombok.Data;

@Data
public class Resume {
    private String resumeId;    // 唯一标识ID
    private String uid;         // 用户ID
    private String name;        // 简历名字
    private String url;         // 简历位置
    private String createdTime; // 创建时间
    private String isDeleted;   // 1为已删除
}
