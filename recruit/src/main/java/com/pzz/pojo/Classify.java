package com.pzz.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Classify {
    private int pkId;// 唯一标识ID
    private int parentId;// 父级ID
    private String name;// 分类名字

    private List<Classify> children;// 子分类
}
