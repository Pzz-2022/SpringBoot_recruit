package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pzz.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
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
    private String createTime;


    public RecordUserRecruit(Integer uid, Integer recruitId) {
        this.uid = uid;
        this.recruitId = recruitId;
        this.createTime = DateUtil.getDate2();
    }
}
