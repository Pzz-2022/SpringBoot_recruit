package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2022-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Classify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer value;

    /**
     * 分类层级
     */
    private Integer level;

    /**
     * 父分类ID
     */
    private Integer parentCid;

    /**
     * 分类名称
     */
    @TableField("name")
    private String label;

    /**
     * 是否删除(0为显示1为删除)
     */
    @TableLogic
    private Integer isDeleted;


    /**
     * 子分类
     */
    @TableField(exist = false)
    private List<Classify> children;
}
