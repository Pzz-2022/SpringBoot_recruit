package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HrInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * HR用户ID
     */
    private Long hrId;

    /**
     * HR用户vx号
     */
    private Long hrVx;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * HR备忘录
     */
    private String hrMemo;

    /**
     * 已招揽的总人数
     */
    private Integer hrRecruitCount;

    /**
     * 已发布的岗位数
     */
    private Integer hrIssueCount;

    /**
     * 正在招聘的岗位数
     */
    private Integer hrIssuingCount;

    /**
     * 接收到求职者的信息的数量（人数）
     */
    private Integer hrReceiveCount;

    /**
     * 是否删除（1为删除）
     */
    @TableLogic
    private Integer isDeleted;


}
