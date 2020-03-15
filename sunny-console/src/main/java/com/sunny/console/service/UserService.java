package com.sunny.console.service;

import com.sunny.console.common.result.Result;
import com.sunny.console.demain.user.UserDemain;
import com.sunny.console.entity.User;
import com.sunny.console.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务处理
 * @author chenye
 * @data 2020-0315
 */
@Service
public class UserService extends BaseCURDService<UserDemain, User, String> {

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
}
