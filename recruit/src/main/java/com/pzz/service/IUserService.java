package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
public interface IUserService extends IService<User> {
    String applyRegister(User user);

    User getByPhone(Long phone);
}
