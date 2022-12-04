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
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordUserRecruit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 招聘ID
     */
    private Integer recruitId;

    /**
     * 查看的时间
     */
    private LocalDateTime createTime;


}
