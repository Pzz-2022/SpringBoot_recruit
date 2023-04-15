package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.HrInfoMapper;
import com.pzz.pojo.HrInfo;
import com.pzz.pojo.Recruit;
import com.pzz.service.IHrInfoService;
import com.pzz.service.IRecruitService;
import com.pzz.service.IRecruitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-06
 */
@Service
public class HrInfoServiceImpl extends ServiceImpl<HrInfoMapper, HrInfo> implements IHrInfoService {
    @Autowired
    private HrInfoMapper hrInfoMapper;
    @Autowired
    private IRecruitService recruitService;
    @Autowired
    private IRecruitUserService recruitUserService;

    @Override
    public void updateByUid(Integer userId) {
        List<Recruit> recruitList = recruitService.getPage(userId);
        int recruitCount = recruitService.getPagePlus(userId);
        Integer count = recruitUserService.selectByHrIdTotal(userId);
        Integer total = 0;
        for (Recruit record : recruitList) {
            total += record.getStatus();
        }


        LambdaQueryWrapper<HrInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(HrInfo::getHrId, userId);

        HrInfo hrInfo = this.getOne(lqw);
        hrInfo.setHrIssueCount(recruitCount);
        hrInfo.setHrIssuingCount(recruitList.size());
        hrInfo.setHrReceiveCount(count);
        hrInfo.setHrRecruitCount(total);

        hrInfoMapper.updateById(hrInfo);
    }
}
