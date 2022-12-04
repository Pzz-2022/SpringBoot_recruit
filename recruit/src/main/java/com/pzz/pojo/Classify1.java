package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2022-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Classify1 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 一级分类ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 一级分类名字
     */
    private String name;


}
