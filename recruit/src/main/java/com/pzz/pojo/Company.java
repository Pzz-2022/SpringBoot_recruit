package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.Year;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司的类型
     */
    private String type;

    /**
     * 公司是否上市
     */
    private Integer isListing;

    /**
     * 公司logo
     */
    private String logo;

    /**
     * 公司人数
     */
    private String count;

    /**
     * 法人姓名
     */
    private String corporation;

    /**
     * 注册地址
     */
    private String address;

    /**
     * 官网链接
     */
    private String owe;

    /**
     * 公司描述
     */
    private String description;

    /**
     * 招聘的数量
     */
    private Integer job;

    /**
     * 公司成立年份
     */
    private Year year;

    /**
     * 创建时间
     */
    private String timeCreate;

    /**
     * 是否删除（有违规行为可封禁）
     */
    @TableLogic
    private Integer isDeleted;


}
