package com.pzz.pojo;

import lombok.Data;

@Data
public class RecruitUserScore {
    private int pkId; // 唯一标识ID
    private int recruitUserId; // 对应的申请职位表ID
    private int userId; // 招聘人的用户ID
    private int score; // 评分
    private String description; // 描述
}
