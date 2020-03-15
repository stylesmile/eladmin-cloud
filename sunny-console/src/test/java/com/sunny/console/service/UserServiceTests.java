package com.sunny.console.service;


import com.sunny.console.demain.user.UserDemain;
import com.sunny.console.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Resource
    UserService userService;

    @Test
    public void getUserListtest() {
        List<User> userList = userService.getUserList();
        System.out.println(userList);
    }


    /**
     * 保存测试-成功
     */
    @Test
    public void saveTest1() {
        UserDemain userDemain = UserDemain.builder()
                .name("zhagnsan")
                .build();
        userService.save(userDemain);
        System.out.println(userDemain);
    }

    /**
     * 保存测试
     */
    @Test
    public void createTest() {
        UserDemain userDemain = UserDemain.builder()
                .name("zhagnsan")
                .build();
        userService.save(userDemain);
        System.out.println(userDemain);
    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest() {
        UserDemain user = UserDemain.builder()
                .id("1sfsdf")
                .email("hkhlk2123")
                .build();
        userService.save(user);
        System.out.println(user);
    }
    /**
     * 修改测试
     */
    @Test
    public void updateTest2() throws Exception {
        UserDemain user = UserDemain.builder()
                .id("1")
                .email("hkhlk123")
                //.name("zhagnsan1")
                .build();
        userService.save(user);
        System.out.println(user);
    }

}
