package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.Admin;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-10
 */
public interface IAdminService extends IService<Admin> {

    Admin login(Admin admin);

    List<Number> userChange(Integer day);

    List<Number> companyChange(Integer day);
}
