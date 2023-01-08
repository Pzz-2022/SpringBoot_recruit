package com.pzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pzz.utils.DateUtil;
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
 * @since 2023-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天记录ID
     */
    @TableId(value = "chat_id", type = IdType.AUTO)
    private Integer chatId;

    /**
     * 发送的用户ID
     */
    private Integer fromUid;

    /**
     * 接收的用户ID
     */
    private Integer toUid;

    /**
     * 发送的内容
     */
    private String content;

    /**
     * 发送时间
     */
    private String sendTime;

    private Integer type;

    public ChatRecord() {
        this.sendTime = DateUtil.getDate2();
    }

    public ChatRecord(String fromUid, String toUid, String content) {
        this.fromUid = Integer.valueOf(fromUid);
        this.toUid = Integer.valueOf(toUid);
        this.content = content;
        this.sendTime = DateUtil.getDate2();
    }
}
