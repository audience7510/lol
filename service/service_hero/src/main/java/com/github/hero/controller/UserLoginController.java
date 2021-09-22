package com.github.hero.controller;

import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.User;
import com.github.hero.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("check")
@Api(tags = "用户登录")
@CrossOrigin
public class UserLoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    @ApiOperation(value = "用户登录",notes = "用户根据用户名和密码登录")
    public Result login(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>();
        map.put("token","admin");
        return ResultGenerator.success(map);
    }

    @GetMapping("info")
    @ApiOperation(value = "用户登录",notes = "用户根据用户名和密码登录")
    public Result info() {
        Map<String,Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://i0.hdslb.com/bfs/face/member/noface.jpg@128w_128h_1o.webp");
        return ResultGenerator.success(map);
    }

}
