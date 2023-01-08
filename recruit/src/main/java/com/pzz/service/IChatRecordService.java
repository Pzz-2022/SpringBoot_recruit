package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.ChatRecord;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-06
 */
public interface IChatRecordService extends IService<ChatRecord> {

    List<ChatRecord> getRecord(Integer uid1, Integer uid2);

    List<Number> getUidList(String uid);
}
