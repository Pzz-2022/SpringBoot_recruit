package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭政
 * @since 2022-12-05
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
     * 公司人数（0-20人、20-99人、100-499人、500-999人、1000-9999人、10000人以上）
     */
    private String count;

    /**
     * 法人姓名
     */
    private String corporation;

    /**
     * 注册地址的城市
     */
    private String address;

    /**
     * 公司描述
     */
    private String description;

    /**
     * HR的数量
     */
    private Integer hrCount;

    /**
     * 招聘的数量
     */
    private Integer jobCount;

    /**
     * 公司成立年份
     */
    private String dateCreate;

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
