package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pzz.mapper.UserMapper;
import com.pzz.pojo.User;
import com.pzz.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.utils.DateUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public String applyRegister(User user) {
        if (user.getCreateTime() == null)
            user.setCreateTime(DateUtil.getDate2());
        String birthday = user.getBirthday();
        if (birthday != null && !birthday.equals(""))
            user.setBirthday(birthday.substring(0, 10));

        this.saveOrUpdate(user);

        String uid = String.valueOf(user.getUid());
        if (uid != null || uid.equals(""))
            return uid;
        return "";
    }

    @Override
    public User getByPhone(Long phone) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getPhone,phone);

        User user = baseMapper.selectOne(lqw);
        if (user != null)
            user.setPassword("");

        return user;
    }

}
