package com.pzz.pojo;

import lombok.Data;

@Data
public class Company {
    private int pkId; // 公司ID
    private String name; // 公司名称
    private String type; // 公司的类型
    private int isListing; // 公司是否上市
    private String logo; // 公司logo
    private int count; // 公司人数
    private String corporation; // 法人姓名
    private String address; // 注册地址
    private String owe; // 官网链接
    private String description; // 公司描述
    private int job; // 招聘的数量
    private String year; // 公司成立年份
    private String timeCreate; // 创建时间
    private int isDeleted; // 是否删除（有违规行为可封禁）
}
