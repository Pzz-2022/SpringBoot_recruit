package com.pzz.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.RecordUserRecruit;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-04
 */
public interface IRecordUserRecruitService extends IService<RecordUserRecruit> {

    Page<RecordUserRecruit> selectRecordByUid(HttpServletRequest request, Long uid);

    JSONObject selectJSONRecordByUid(HttpServletRequest request, Long uid);

    void updateRecord(HttpServletRequest request);
}
