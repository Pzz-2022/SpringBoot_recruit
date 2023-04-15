package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.AdminMapper;
import com.pzz.pojo.Admin;
import com.pzz.pojo.Company;
import com.pzz.pojo.User;
import com.pzz.service.IAdminService;
import com.pzz.service.ICompanyService;
import com.pzz.service.IUserService;
import com.pzz.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICompanyService companyService;

    @Override
    public Admin login(Admin admin) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Admin::getAccount, admin.getAccount()).eq(Admin::getPassword, admin.getPassword());

        admin = adminMapper.selectOne(lqw);
        if (admin == null)
            return null;

        admin.setPassword("");
        return admin;
    }

    @Override
    public List<Number> userChange(Integer day) {
        ArrayList<Number> nums = new ArrayList<>();

        for (int i = 1-day; i <= 0; i++) {
            String dayStr = DateUtil.getDate1(i);

            LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
            lqw.like(User::getCreateTime, dayStr);

            Integer count = userService.getBaseMapper().selectCount(lqw);

            nums.add(count);
        }
        return nums;
    }

    @Override
    public List<Number> companyChange(Integer day) {
        ArrayList<Number> nums = new ArrayList<>();

        for (int i = 1-day; i <= 0; i++) {
            String dayStr = DateUtil.getDate1(i);

            LambdaQueryWrapper<Company> lqw = new LambdaQueryWrapper<>();
            lqw.like(Company::getTimeCreate, dayStr);

            Integer count = companyService.getBaseMapper().selectCount(lqw);

            nums.add(count);
        }
        return nums;
    }
}
