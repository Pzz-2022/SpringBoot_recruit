package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pzz.pojo.Recruit;
import com.pzz.pojo.RecruitUser;
import com.pzz.mapper.RecruitUserMapper;
import com.pzz.service.IRecruitService;
import com.pzz.service.IRecruitUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.service.IResumeService;
import com.pzz.service.IUserService;
import com.pzz.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@Service
public class RecruitUserServiceImpl extends ServiceImpl<RecruitUserMapper, RecruitUser> implements IRecruitUserService {
    @Autowired
    private IUserService userService;
    @Autowired
    private IResumeService resumeService;
    @Autowired
    private IRecruitService recruitService;
    @Autowired
    private RecruitUserMapper recruitUserMapper;

    @Override
    public List<Integer> getApplyChange(int rid) {
        List<Integer> nums = new ArrayList<>();

        for (int i = -9; i <= 0; i++) {
            String dateString = DateUtil.getDate1(i);
            int num = recruitUserMapper.selectApplyByDay(rid, dateString);
            nums.add(num);
        }

        return nums;
    }

    @Override
    public int getApplyNum(int rid) {

        return recruitUserMapper.selectApplyNum(rid);
    }

    @Override
    public RecruitUser selectOne(Integer uid, Integer rid) {
        LambdaQueryWrapper<RecruitUser> lqw = new LambdaQueryWrapper<>();
        lqw.ne(RecruitUser::getStatus, 0);
        lqw.eq(RecruitUser::getUserId, uid);
        lqw.eq(RecruitUser::getRecruitId, rid);

        return recruitUserMapper.selectOne(lqw);
    }

    @Override
    public List<RecruitUser> selectByHrId(Integer hrId, Integer pageNow, Integer pageSize) {
        List<RecruitUser> recruitUserList = recruitUserMapper.selectByHrId(hrId, (pageNow - 1) * pageSize, pageSize);
        for (RecruitUser recruitUser : recruitUserList) {
            recruitUser.setUser(userService.getById(recruitUser.getUserId()));
            recruitUser.setResume(resumeService.getById(recruitUser.getResumeId()));
            recruitUser.setRecruit(recruitService.getById(recruitUser.getRecruitId()));
        }

        return recruitUserList;
    }

    @Override
    public Integer selectByHrIdTotal(Integer hrId) {
        return recruitUserMapper.selectByHrIdTotal(hrId);
    }
}