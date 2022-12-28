package com.pzz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzz.mapper.ClassifyMapper;
import com.pzz.pojo.Classify;
import com.pzz.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 彭政
 * @since 2022-12-27
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public List<Classify> selectAll() {
        // 将第一层的先搜出来
        LambdaQueryWrapper<Classify> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Classify::getLevel, 1);

        List<Classify> classifyList = classifyMapper.selectList(lqw1);

        // 使用循环将后面的第二层搜出来
        for (Classify classify : classifyList) {
            LambdaQueryWrapper<Classify> lqw2 = new LambdaQueryWrapper<>();
            lqw2.eq(Classify::getLevel, 2);
            lqw2.eq(Classify::getParentCid, classify.getValue());

            classify.setChildren(classifyMapper.selectList(lqw2));

            // 搜第三层
            if (classify.getChildren() != null)
                for (Classify child : classify.getChildren()) {
                    LambdaQueryWrapper<Classify> lqw3 = new LambdaQueryWrapper<>();
                    lqw3.eq(Classify::getLevel, 3);
                    lqw3.eq(Classify::getParentCid, child.getValue());

                    child.setChildren(classifyMapper.selectList(lqw3));
                }
        }

        return classifyList;
    }
}
