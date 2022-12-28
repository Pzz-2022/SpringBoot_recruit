package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Classify;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-27
 */
public interface IClassifyService extends IService<Classify> {

    List<Classify> selectAll();
}
