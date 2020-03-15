package com.sunny.system.rest;

import com.sunny.system.common.result.Result;
import com.sunny.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "/swagger/login")
@RestController
public class LoginController {

    @Resource
    UserService userService;

    @ApiOperation(value = "login", notes = "登录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "admin", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "123456", value = "name", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public Result login(@RequestParam("name") String name,
                        @RequestParam("name") String password) {
        return userService.login(name, password);
    }
}
