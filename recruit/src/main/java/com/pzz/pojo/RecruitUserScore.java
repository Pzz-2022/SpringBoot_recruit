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
public class RecruitUserScore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID
     */
    @TableId(value = "pk_id", type = IdType.ASSIGN_ID)
    private Integer pkId;

    /**
     * 对应的申请招聘的ID
     */
    private Integer recruitUserId;

    /**
     * 招聘人ID
     */
    private Integer userId;

    /**
     * 招聘人给的评分
     */
    private Integer score;

    /**
     * 招聘人给的评价
     */
    private String description;


}
