package com.pzz.pojo;

import lombok.Data;

@Data
public class Keyword {
    private int pkId; // 唯一标识ID
    private String Keyword; // 关键字
    private String createTime; // 创建时间
    private int isDeleted; // 是否删除
}
