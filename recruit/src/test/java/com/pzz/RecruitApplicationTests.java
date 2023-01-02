package com.pzz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pzz.mapper.ClassifyMapper;
import com.pzz.mapper.RecruitMapper;
import com.pzz.mapper.UserMapper;
import com.pzz.pojo.Recruit;
import com.pzz.pojo.RecruitUser;
import com.pzz.pojo.Resume;
import com.pzz.pojo.User;
import com.pzz.service.IRecruitService;
import com.pzz.service.IRecruitUserService;
import com.pzz.service.IResumeService;
import com.pzz.service.IUserService;
import com.pzz.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
    private IResumeService resumeService;

    @Autowired
    private IRecruitUserService recruitUserService;


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

    @Test
    void addUser() {
        // 创建的起始ID
        int start = 37;

        User user = new User();
        user.setPassword("1fd88d3ff084883fade1f3eb845ea95a");
        user.setHeadPortrait("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
        user.setGender("男");
        user.setBirthday("2002-09-09");
        user.setIsStudent(0);
        user.setEducation("本科");
        user.setSchool("吉首大学");
        user.setSpecialty("软件工程");
        user.setCompanyId(0);
        user.setPermission(1);
        user.setAccountApply(0);
        user.setAccountIssue(0);
        for (int i = 0; i < 1000; i++) {
            long id = i + start;

            user.setUid(id);
            user.setName(id + "号");
            user.setPhone(id);
            user.setCreateTime(DateUtil.getDate2());

            userService.saveOrUpdate(user);
        }
    }

    @Test
    void addResume() {
        // 创建的用户ID
        int start = 37;
        int resumeIdStart = 10;

        Resume resume = new Resume();
        resume.setUrl("http://localhost:8088/static/41ef5aa9b1d241d9818e1a5bba36a903.pdf");
        for (int i = 0; i < 1000; i++) {
            long id = i + start;
            long resumeId = resumeIdStart + i;

            resume.setResumeId(resumeId);
            resume.setUid(id);
            resume.setName(id + "号的个人简历");
            resume.setCreatedTime(DateUtil.getDate2());

            resumeService.saveOrUpdate(resume);
        }
    }

    @Test
    void addRecruitUser() {
        int start = 37;
        int resumeIdStart = 10;
        int recruitUserStart = 3;

        RecruitUser recruitUser = new RecruitUser();
        recruitUser.setAvgScore(0d);
        recruitUser.setStatus(1);
        recruitUser.setRecruitId(1);
        for (int i = 0; i < 1000; i++) {
            int id = i + start;
            int resumeId = resumeIdStart + i;
            int recruitUserId = recruitUserStart + i;

            recruitUser.setPkId(recruitUserId);
            recruitUser.setUserId(id);
            recruitUser.setResumeId(resumeId);
            recruitUser.setTime(DateUtil.getDate2());

            recruitUserService.saveOrUpdate(recruitUser);
        }

    }
}

