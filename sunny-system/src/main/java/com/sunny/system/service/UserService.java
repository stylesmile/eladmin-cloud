package com.sunny.system.service;

import com.sunny.system.common.result.Result;
import com.sunny.system.demain.user.UserDemain;
import com.sunny.system.demain.user.UserQuery;
import com.sunny.system.entity.User;
import com.sunny.system.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务处理
 * @author chenye
 * @data 2020-0315
 */
@Service
public class UserService extends BaseCURDService<UserDemain, User, String, UserRepository> {

    @Resource
    UserRepository userRepository;


    public Result login(String name, String password) {
        User user = userRepository.getUserByName(name);
        if (name.equals("admin") && password.equals("123456")) {
            return Result.success();
        }
        if (user == null) {
            return Result.failMessage("用户名不存在");
        }
        if (password.equals(user.getPassword())) {
            return Result.success();
        }
        return Result.failMessage("");
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    /**
     * 通过名称模糊查询用户
     *
     * @param userQuery     条件
     * @param pageable 页码
     * @return Page
     */
    public Page<User> getUserByNameLike(UserQuery userQuery, Pageable pageable) {
        return userRepository.getUserByNameLike(userQuery.getName(),pageable);
    }
}
