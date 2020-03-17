package com.sunny.system.rest;

import com.sunny.system.common.result.Result;
import com.sunny.system.demain.user.UserCreate;
import com.sunny.system.demain.user.UserDemain;
import com.sunny.system.demain.user.UserModify;
import com.sunny.system.demain.user.UserQuery;
import com.sunny.system.entity.User;
import com.sunny.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("/swagger/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable("id") String id) {

        User user = userService.getById(id);
        return Result.success(user);
    }

    @GetMapping("/add")
    @ApiOperation(value = "add")
    public Result add(UserCreate userAdd) {
        User user = new User();
        BeanUtils.copyProperties(userAdd,user);
        userService.save(user);
        return Result.success();
    }


    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        return Result.bool(userService.delete(id));
    }

    @GetMapping("/update")
    public Result update(UserModify userModify) {
        User user = new User();
        BeanUtils.copyProperties(userModify,user);
        return Result.bool(userService.save(user));
    }

    @GetMapping("/getList")
    public Result getList(UserQuery userModify, Pageable pageable) {
        UserDemain userDemain = new UserDemain();
        BeanUtils.copyProperties(userModify, userDemain);
        return Result.success(userService.search(userDemain, pageable));
    }

}