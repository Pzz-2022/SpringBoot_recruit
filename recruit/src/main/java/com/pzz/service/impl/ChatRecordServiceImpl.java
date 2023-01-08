package com.pzz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.ChatRecordMapper;
import com.pzz.pojo.ChatRecord;
import com.pzz.service.IChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-06
 */
@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements IChatRecordService {
    @Autowired
    private ChatRecordMapper chatRecordMapper;

    @Override
    public List<ChatRecord> getRecord(Integer uid1, Integer uid2) {
        return chatRecordMapper.selectRecord(uid1, uid2);
    }

    @Override
    public List<Number> getUidList(String uid) {
        List<ChatRecord> chatRecordLIst = chatRecordMapper.getUidList(uid);
        HashSet<Number> uidSet = new HashSet<>();

        for (ChatRecord chatRecord : chatRecordLIst) {
            uidSet.add(chatRecord.getFromUid());
            uidSet.add(chatRecord.getToUid());
        }
        uidSet.remove(Integer.parseInt(uid));

        return new ArrayList<>(uidSet);
    }


}
