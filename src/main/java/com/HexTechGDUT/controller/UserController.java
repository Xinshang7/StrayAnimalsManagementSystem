package com.HexTechGDUT.controller;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.po.User;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.UserService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author HexTechGDUT
 */
@Api("用户")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @PassToken
    @ApiOperation("注册")
    @PostMapping("/register")
    public @ResponseBody Result<User> register(@ApiParam("用户注册信息")@Validated @RequestBody User user){
        boolean isSuccess = userService.register(user);
        user.setPassword("");
        if(isSuccess){
            return ResultUtils.successWithInfo(user, "注册成功");
        }
        return ResultUtils.failWithInfo(user, "注册失败");
    }

    @PassToken
    @ApiOperation("登录")
    @PostMapping("/login")
    public @ResponseBody Result<String> login(@ApiParam("用户登录Bo") @Validated @RequestBody LoginBo loginBo){
        return ResultUtils.successWithInfo(userService.login(loginBo), "登录成功");
    }

    @AuthToken
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public @ResponseBody Result<User> update(@ApiParam("用户更新信息")@Validated @RequestBody User user){
        boolean isSuccess = userService.updateUser(user);
        user.setPassword("");
        if(isSuccess){
            return ResultUtils.successWithInfo(user, "更新成功");
        }
        return ResultUtils.failWithInfo(user, "更新失败");
    }

    @PassToken
    @ApiOperation("来到首页")
    @GetMapping("/index")
    public @ResponseBody Result<String> toIndex(){
        return ResultUtils.success("来到首页");
    }
}
