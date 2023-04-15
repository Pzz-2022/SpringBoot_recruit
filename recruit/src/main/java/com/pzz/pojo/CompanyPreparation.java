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
 * @since 2023-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 申请的公司ID
     */
    private Integer cid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司logo
     */
    private String logo;

    /**
     * 公司营业执照
     */
    private String documents;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 状态（0未通过 1审核中 2已通过 3完成）
     */
    private Integer status;


}
