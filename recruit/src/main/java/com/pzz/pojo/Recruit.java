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
public class Recruit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 招聘负责人
     */
    private Integer userId;

    /**
     * 招聘的主题名字
     */
    private String theme;

    /**
     * 三级职位分类ID
     */
    private Integer classifyId;

    /**
     * 实习/应届/社招
     */
    private String type;

    /**
     * 招聘人数
     */
    private Integer num;

    /**
     * 招聘城市
     */
    private String city;

    /**
     * 招聘要求
     */
    private String description;

    /**
     * 薪资的左端点（单位为k）
     */
    private Integer salaryStart;

    /**
     * 薪资的右端点（0为面议）
     */
    private Integer salaryEnd;

    /**
     * 月薪制度（14薪填的字段值为14）
     */
    private Integer salaryCount;

    /**
     * 发布招聘时间
     */
    private String timeStart;

    /**
     * 报名结束时间
     */
    private String timeEnd;

    /**
     * 招聘状态
     */
    private Integer status;

    /**
     * 招聘创建时间
     */
    private String timeCreate;

    /**
     * 平均反馈时长
     */
    private Integer timeFeedback;

    /**
     * 最近一次修改时间
     */
    private String timeChange;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;


}
