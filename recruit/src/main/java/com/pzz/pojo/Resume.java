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
 * @since 2022-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID
     */
    @TableId(value = "resume_id", type = IdType.AUTO)
    private Long resumeId;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 简历名字
     */
    private String name;

    /**
     * 简历位置
     */
    private String url;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 1为已删除
     */
    @TableLogic
    private Integer isDeleted;


}
