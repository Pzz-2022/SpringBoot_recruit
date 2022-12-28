package com.pzz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.RecordUserRecruit;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-04
 */
public interface IRecordUserRecruitService extends IService<RecordUserRecruit> {

    Page<RecordUserRecruit> selectRecordByUid(Long uid);
}
