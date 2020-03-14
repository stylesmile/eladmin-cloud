package com.sunny.service;


import com.sunny.demain.UserDemain;
import com.sunny.entity.User;
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
        User userDemain = User.builder()
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
        userService.create(userDemain);
        System.out.println(userDemain);
    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest() {
        User user = User.builder()
                .id(1)
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
                .id(1)
                .email("hkhlk123")
                //.name("zhagnsan1")
                .build();
        userService.update(user);
        System.out.println(user);
    }

}
