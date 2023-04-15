package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.HrPreparationMapper;
import com.pzz.pojo.HrPreparation;
import com.pzz.pojo.User;
import com.pzz.service.ICompanyService;
import com.pzz.service.IHrPreparationService;
import com.pzz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
@Service
public class HrPreparationServiceImpl extends ServiceImpl<HrPreparationMapper, HrPreparation> implements IHrPreparationService {
    @Autowired
    private HrPreparationMapper hrPreparationMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICompanyService companyService;

    @Override
    public IPage<HrPreparation> getPage(Integer page, Integer size) {
        Page<HrPreparation> iPage = new Page<>(page, size);
        LambdaQueryWrapper<HrPreparation> lqw = new LambdaQueryWrapper<>();
        lqw.eq(HrPreparation::getStatus, 1);

        Page<HrPreparation> hrPreparationPage = hrPreparationMapper.selectPage(iPage, lqw);
        for (HrPreparation hrPreparation : hrPreparationPage.getRecords()) {
            hrPreparation.setUser(userService.getById(hrPreparation.getHrId()));
            hrPreparation.setCompany(companyService.getById(hrPreparation.getCompanyId()));
        }

        return hrPreparationPage;
    }

    @Override
    public void updateUser(HrPreparation hrPreparation) {
        hrPreparation = hrPreparationMapper.selectById(hrPreparation.getPkId());

        User user = new User();
        user.setUid(hrPreparation.getHrId());

        if (hrPreparation.getStatus() == 0) {
            user.setCompanyId(0);

            userService.updateById(user);
        } else if (hrPreparation.getStatus() == 2) {
            user.setCompanyId(hrPreparation.getCompanyId());
            user.setPositionName(hrPreparation.getPositionName());

            userService.updateById(user);
        }
    }
}
