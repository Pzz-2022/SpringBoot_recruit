package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一ID
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号码
     */
    private Long phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String headPortrait;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户签名
     */
    private String signature;

    /**
     * 用户生日
     */
    private LocalDate birthday;

    /**
     * 用户是否为在校生（0为非在校生，有数字为毕业年份）
     */
    private Integer isStudent;

    /**
     * 用户学历
     */
    private String education;

    /**
     * 用户学校
     */
    private String school;

    /**
     * 用户专业
     */
    private String specialty;

    /**
     * 作为某个公司的负责人（0则无）
     */
    private Integer companyId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 用户权限（0为封禁用户1为普通用户2为实习员工3为正式员工4为公司管理者）
     */
    private Integer permission;

    /**
     * 注册时间
     */
    private LocalDateTime timeCreate;

    /**
     * 申请职位的数量
     */
    private Integer accountApply;

    /**
     * 发布招聘的数量
     */
    private Integer accountIssue;


}
