package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Keyword implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 1为删除
     */
    @TableLogic
    private Integer isDeleted;


}
