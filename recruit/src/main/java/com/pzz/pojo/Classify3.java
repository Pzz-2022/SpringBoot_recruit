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
public class Classify3 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 三级分类的ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 从属二级分类的ID
     */
    private Integer parentId;

    /**
     * 三级分类的名字
     */
    private String name;


}
