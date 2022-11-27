package com.pzz.pojo;

import lombok.Data;

// lombok
@Data
public class User {
    private long uid;               // 用户唯一ID
    private String name;            // 用户名
    private String password;        // 用户密码
    private long phone;             // 用户手机号码
    private String email;           // 用户邮箱
    private String headPortrait;    // 用户头像
    private char gender;            // 用户性别
    private String signature;       // 用户签名
    private String birthday;        // 用户生日
    private int isStudent;          // 用户是否为在校生（0为非在校生，有数字为毕业年份）
    private String education;       // 用户学历
    private String school;          // 用户学校
    private String specialty;       // 用户专业
    private int companyId;          // 作为某个公司的负责人（0则无）
    private String positionName;    // 职位名称
    private int permission;         // 用户权限（0为封禁用户1为普通用户2为实习员工3为正式员工4为公司管理者）
    private String timeCreate;      // 注册时间
    private int accountApply;       // 申请职位的数量
    private int accountIssue;       // 发布招聘的数量
}
