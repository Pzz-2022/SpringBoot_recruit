package com.pzz.pojo;

import lombok.Data;

@Data
public class Recruit {
    private int pkId; // 唯一标识
    private int companyId; // 公司ID
    private int userId; // 招聘负责人
    private String theme; // 招聘的主题名字
    private int classifyId; // 三级职位分类ID
    private String type; // 实习/应届/社招
    private int num; // 招聘人数
    private String city; // 招聘城市
    private String description; // 招聘要求
    private int salaryStart; // 薪资的左端点（单位为k）
    private int salaryEnd; // 薪资的右端点（0为面议）
    private int salaryCount; // 月薪制度（14薪填的字段值为14）
    private String timeStart; // 发布招聘时间
    private String timeEnd; // 报名结束时间
    private int status; // 招聘状态
    private String timeCreate; // 招聘创建时间
    private int timeFeedback; // 平均反馈时长
    private String timeChange; // 最近一次修改时间
    private int isDeleted; // 是否删除
}
