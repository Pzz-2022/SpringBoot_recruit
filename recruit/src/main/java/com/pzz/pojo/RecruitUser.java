package com.pzz.pojo;

import lombok.Data;

@Data
public class RecruitUser {
    private int pkId;
    private int userId;
    private int recruitId;
    private String time;
    private double avgScore;
    private int status;
}
