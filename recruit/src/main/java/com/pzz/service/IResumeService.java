package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Resume;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface IResumeService extends IService<Resume> {

    List<Resume> getByUid(Integer uid);
}
