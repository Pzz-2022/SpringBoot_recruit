package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pzz.mapper.ResumeMapper;
import com.pzz.pojo.Resume;
import com.pzz.service.IResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements IResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public List<Resume> getByUid(Integer uid) {
        LambdaQueryWrapper<Resume> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Resume::getUid, uid);

        return resumeMapper.selectList(lqw);
    }
}
