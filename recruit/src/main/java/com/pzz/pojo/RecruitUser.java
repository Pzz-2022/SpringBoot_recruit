package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author 彭政
 * @since 2022-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
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
     * 简历的ID
     */
    private Integer resumeId;

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

    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Recruit recruit;
    @TableField(exist = false)
    private Resume resume;

    public RecruitUser(Integer pkId, Integer status) {
        this.pkId = pkId;
        this.status = status;
    }
}
