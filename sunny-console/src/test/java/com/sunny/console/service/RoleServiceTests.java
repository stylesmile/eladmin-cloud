package com.sunny.console.service;


import com.sunny.console.demain.role.RoleDemain;
import com.sunny.console.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceTests {

    @Resource
    RoleService roleService;

    @Test
    public void getRoleListtest() {
        List<Role> RoleList = roleService.getRoleList();
        System.out.println(RoleList);
    }

    @Test
    public void saveTest() {
        RoleDemain role = RoleDemain.builder()
                .name("zhagnsan")
                .build();
        roleService.save(role);
        System.out.println(role);
    }
    @Test
    public void updateTest() {
        RoleDemain role = RoleDemain.builder()
                .name("zhagnsan")
                .build();
        roleService.modify(role);
        System.out.println(role);
    }

}
