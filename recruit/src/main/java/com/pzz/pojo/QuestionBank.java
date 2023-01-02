package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2023-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionBank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题库分类ID
     */
    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 题库名字
     */
    private String name;

    /**
     * 题库描述
     */
    private String signature;

    /**
     * 题目数量
     */
    private Integer questionCount;

    /**
     * 题库创建时间
     */
    private String createTime;

    /**
     * 是否删除（1为删除）
     */
    @TableLogic
    private Integer isDeleted;


}
