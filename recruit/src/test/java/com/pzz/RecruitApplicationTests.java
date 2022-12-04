package com.pzz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.mapper.Classify1Mapper;
import com.pzz.mapper.RecruitMapper;
import com.pzz.mapper.UserMapper;
import com.pzz.pojo.Recruit;
import com.pzz.pojo.User;
import com.pzz.service.IRecruitService;
import com.pzz.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class RecruitApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRecruitService recruitService;

    @Autowired
    private RecruitMapper recruitMapper;

    @Autowired
    private Classify1Mapper classify1Mapper;


    @Test
    void contextLoads() {
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    void test1() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void test2() {
        //分页参数
        Page<Recruit> rowPage = new Page(0, 5);

        Page<Recruit> recruitPage = recruitMapper.selectPage(rowPage, null);

        System.out.println();
        System.out.println(recruitPage);
        System.out.println(recruitPage.getRecords());
    }

    @Test
    void testClass() {
        System.out.println(recruitMapper.selectAll());
    }
}

