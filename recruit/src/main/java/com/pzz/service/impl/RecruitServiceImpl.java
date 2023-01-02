package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.mapper.RecruitMapper;
import com.pzz.pojo.Recruit;
import com.pzz.service.IRecruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RecruitServiceImpl extends ServiceImpl<RecruitMapper, Recruit> implements IRecruitService {
    @Autowired
    private RecruitMapper recruitMapper;

    @Override
    public Page<Recruit> getPage(int page, int pageSize) {
        // 分页参数
        Page<Recruit> rowPage = new Page(page, pageSize);
        LambdaQueryWrapper<Recruit> lqw = new LambdaQueryWrapper<>();
        lqw.apply("num > status");

        return baseMapper.selectPage(rowPage, lqw);
    }

    @Override
    public Page<Recruit> getPage(int uid, int pageNow, int pageSize) {
        // 分页、查询参数
        Page<Recruit> rowPage = new Page(pageNow, pageSize);
        LambdaQueryWrapper<Recruit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Recruit::getUserId, uid);
        lqw.apply("num > status");

        return baseMapper.selectPage(rowPage, lqw);
    }

    @Override
    public Page<Recruit> getSearchList(int page, int pageSize, String q, String city, String experience, String education, String salary) {
        // 分页参数
        Page<Recruit> recruitPage = new Page(page, pageSize);

        // 将薪水的范围解析
        String[] split = salary.split("-");
        int salaryStart = 0;
        int salaryEnd = Integer.MAX_VALUE;

        if (!salary.equals("") && !salary.equals("-"))
            if (split.length == 2) {
                salaryStart = Integer.parseInt(split[0]);
                salaryEnd = Integer.parseInt(split[1]);
            } else if (split.length == 1) {
                salaryStart = Integer.parseInt(split[0]);
            }

        recruitPage.setTotal(recruitMapper.selectSearchListTotal(q, city, experience, education, salaryStart, salaryEnd));
        recruitPage.setRecords(recruitMapper.selectSearchList((page - 1) * pageSize, pageSize, q, city, experience, education, salaryStart, salaryEnd));
        recruitPage.setPages(recruitPage.getTotal() % pageSize != 0 ? 1 + recruitPage.getTotal() / pageSize : recruitPage.getTotal() / pageSize);

        return recruitPage;
    }


}
