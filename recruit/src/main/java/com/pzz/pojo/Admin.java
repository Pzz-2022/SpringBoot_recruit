package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    /**
     * 管理员账号
     */
    private Integer account;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String name;

    private Integer power;

    /**
     * 创建时间
     */
    private String createTime;


}
