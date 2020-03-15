package com.sunny.console.rest;

import com.sunny.console.common.result.Result;
import com.sunny.console.demain.user.UserDemain;
import com.sunny.console.demain.user.UserCreate;
import com.sunny.console.demain.user.UserModify;
import com.sunny.console.demain.user.UserQuery;
import com.sunny.console.entity.User;
import com.sunny.console.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("/swagger/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable("id") String id){

        User user = userService.getById(id);
        return Result.success(user);
    }

    @GetMapping("/add")
    @ApiOperation(value = "add")
    public Result add(UserCreate userAdd) {
        UserDemain userDemain = new UserDemain();
        BeanUtils.copyProperties(userAdd, userDemain);
        userService.save(userDemain);
        return Result.success();
    }


    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        return Result.bool(userService.delete(id));
    }

    @GetMapping("/update")
    public Result update(UserModify userModify) {
        UserDemain userDemain = new UserDemain();
        BeanUtils.copyProperties(userModify, userDemain);
        return Result.bool(userService.save(userDemain));
    }

    @GetMapping("/getList")
    public Result getList(UserQuery userModify) {
        UserDemain userDemain = new UserDemain();
        BeanUtils.copyProperties(userModify, userDemain);
        return Result.success(userService.save(userDemain));
    }

}