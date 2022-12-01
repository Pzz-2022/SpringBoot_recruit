package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.pojo.Recruit;
import com.pzz.mapper.RecruitMapper;
import com.pzz.service.IRecruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@Service
public class RecruitServiceImpl extends ServiceImpl<RecruitMapper, Recruit> implements IRecruitService {

    @Override
    public Page<Recruit> getPage(int page, int pageSize) {
        //分页参数
        Page<Recruit> rowPage = new Page(page, pageSize);

        LambdaQueryWrapper<Recruit> lqw = new LambdaQueryWrapper<>();


        Page<Recruit> recruitPage = baseMapper.selectPage(rowPage, lqw);

        return recruitPage;
    }


}
