package com.sunny.system.service;


import com.sunny.system.demain.user.UserDemain;
import com.sunny.system.demain.user.UserQuery;
import com.sunny.system.entity.User;
import com.sunny.system.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
     * 保存测试
     */
    @Test
    public void createTest() {
        UserDemain userDemain = UserDemain.builder()
                .userName("zhagnsan2")
                .build();
        User user = new User();
        BeanUtils.copyProperties(userDemain, user);
        userService.save(user);
        System.out.println(userDemain);
    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest() {
        UserDemain userDemain = UserDemain.builder()
                .id("4028818870dea3e60170dea3f0a10000")
                .userName("hkhlk2123")
                .build();
        User user = new User();
        BeanUtils.copyProperties(userDemain, user);
        userService.save(user);
        System.out.println(user);
    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest2() throws Exception {
        UserDemain userDemain = UserDemain.builder()
                .id("4028818870dea3e60170dea3f0a10000")
                .email("hkhlk123")
                .userName("zhagnsan1")
                .build();
        User user = new User();
        BeanUtils.copyProperties(userDemain, user);
        userService.save(user);
        System.out.println(user);
    }
    /**
     * 查询测试
     */
    @Test
    public void getList(){
        UserQuery userQuery = UserQuery.builder()
                //..userName("zhangsan")
                .build();
        Pageable pageable = PageRequest.of(
                0, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<User> userPage = userService.search(userQuery,pageable);
        System.out.println(JsonUtil.toJson(userPage));
    }

    /**
     * 测试
     */
    @Test
    public void getList2() {
        UserQuery userQuery = UserQuery.builder()
                .userName("zhangsan")
                .build();

        Pageable pageable = PageRequest.of(
                1, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<User> userPage = userService.getUserByNameLike(userQuery,pageable);
        System.out.println(JsonUtil.toJson(userPage));
    }
    @Test
    public void getList3() {
        List<User> userList = userService.getUserList();
        System.out.println(JsonUtil.toJson(userList));
    }


}
