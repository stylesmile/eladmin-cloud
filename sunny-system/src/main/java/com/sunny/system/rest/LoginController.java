package com.sunny.system.rest;

import com.sunny.system.common.result.Result;
import com.sunny.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenye
 * @date 2020-0314
 */
@Api(value = "/swagger/login")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    UserService userService;

    @ApiOperation(value = "login", notes = "登录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userName", value = "用户名", example = "admin", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", example = "admin", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        return userService.login(userName, password);
    }
}
