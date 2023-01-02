package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.pzz.utils.DateUtil;
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


    public Resume() {
        this.createdTime = DateUtil.getDate2();
    }

    public Resume(Long uid, String url) {
        this.uid = uid;
        this.url = url;
        this.name = uid + "的简历";
        this.createdTime = DateUtil.getDate2();
    }

    public Resume(Long uid, String url, String name) {
        this.uid = uid;
        this.url = url;
        this.name = name;
        this.createdTime = DateUtil.getDate2();
    }
}
