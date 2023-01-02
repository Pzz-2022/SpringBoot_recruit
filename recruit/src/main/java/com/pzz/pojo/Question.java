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
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目的ID
     */
    @TableId(value = "qid", type = IdType.AUTO)
    private Integer qid;

    /**
     * 所属题库ID
     */
    private Integer bid;

    /**
     * 题目的类型（1单选题2多选题3判断题）
     */
    private Integer type;

    /**
     * 题目的描述
     */
    private String content;

    /**
     * 选项一
     */
    private String option1;

    /**
     * 选项二
     */
    private String option2;

    /**
     * 选项三
     */
    private String option3;

    /**
     * 选项四
     */
    private String option4;

    /**
     * 答案
     */
    private String answer;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 是否删除（1为删除）
     */
    @TableLogic
    private Integer isDeleted;


}
