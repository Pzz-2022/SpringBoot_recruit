package com.pzz.controller;


import com.pzz.pojo.ChatRecord;
import com.pzz.service.IChatRecordService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2023-01-06
 */
@RestController
@RequestMapping("/chatRecord")
public class ChatRecordController {
    @Autowired
    private IChatRecordService chatRecordService;

    @GetMapping("/record")
    public JsonResult getRecord(Integer uid1, Integer uid2) {
        List<ChatRecord> chatRecordList = chatRecordService.getRecord(uid1, uid2);

        return JsonResult.judge("chatRecordList", chatRecordList);
    }

}

