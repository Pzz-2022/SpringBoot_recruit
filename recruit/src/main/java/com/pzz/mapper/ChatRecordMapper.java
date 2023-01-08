package com.pzz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzz.pojo.ChatRecord;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 彭政
 * @since 2023-01-06
 */
public interface ChatRecordMapper extends BaseMapper<ChatRecord> {

    List<ChatRecord> selectRecord(Integer uid1, Integer uid2);

    List<ChatRecord> getUidList(String uid);
}
