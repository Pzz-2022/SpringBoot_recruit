package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class HrPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * HR的ID
     */
    private Long hrId;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 在职证明
     */
    private String prove;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 状态（0失败 1审核 2通过 3完成）
     */
    private Integer status;

    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Company company;

}
