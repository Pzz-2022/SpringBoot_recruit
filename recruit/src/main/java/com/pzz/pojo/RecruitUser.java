package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecruitUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 申请人
     */
    private Integer userId;

    /**
     * 申请招聘的ID
     */
    private Integer recruitId;

    /**
     * 申请时间
     */
    private String time;

    /**
     * 招聘人给的评分的平均分
     */
    private Double avgScore;

    /**
     * 招聘状态（0未录用，1筛简历，2笔试，3面试，4录用）
     */
    private Integer status;


}
