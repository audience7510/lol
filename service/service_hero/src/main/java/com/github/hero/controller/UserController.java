package com.github.hero.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.hero.common.Contain;
import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.User;
import com.github.hero.pojo.UserQuery;
import com.github.hero.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
@CrossOrigin
public class UserController {

    private static String path = "templates";
    @Autowired
    private IUserService userService;


    @PostMapping("list/{current}/{size}")
    @ApiOperation(value = "用户列表",notes = "查询所有用户")
    public Result list(@PathVariable int current, @PathVariable int size,
                       @RequestBody UserQuery userQuery) {
        Page<User> page = new Page<>(current,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        String userName = userQuery.getUserName();
        String nickName = userQuery.getNickName();
        String createTimeStart = userQuery.getCreateTimeStart();
        String createTimeEnd = userQuery.getCreateTimeEnd();
        if (!StringUtils.isEmpty(userName)){
            queryWrapper.like("user_name",userName);
        }
        if (!StringUtils.isEmpty(nickName)){
            queryWrapper.like("nick_name",nickName);
        }
        if (!StringUtils.isEmpty(createTimeStart)){
            queryWrapper.ge("create_time",createTimeStart);
        }
        if (!StringUtils.isEmpty(createTimeEnd)){
            queryWrapper.le("create_time",createTimeEnd);
        }
        queryWrapper.eq("is_delete","0");
        queryWrapper.orderByDesc("create_time");
        IPage<User> iPage = userService.page(page, queryWrapper);
        return ResultGenerator.success(iPage);
    }

    @GetMapping("findAll")
    @ApiOperation(value = "查询所有用户列表",notes = "查询所有用户列表，全查，列表返回")
    public Result findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_delete","0");
        List<User> list = userService.list(queryWrapper);
        return ResultGenerator.success(list);
    }

    @PostMapping("add")
    @ApiOperation(value = "新增用户",notes = "新增用户之后，设置默认登录账号和密码")
    public Result add(@RequestBody User user) {
        String pinyin = PinyinUtil.getPinyin(user.getUserName());
        user.setLoginName(pinyin.replaceAll(" ",""));
        user.setPassWord(Contain.PASSWORD);
        user.setCreateTime(DateUtil.now());
        boolean save = userService.save(user);
        if (save){
            return ResultGenerator.success();
        }else {
            return ResultGenerator.fail("新增失败");
        }
    }

    @GetMapping("getUser/{id}")
    @ApiOperation(value = "根据用户id查询用户信息",notes = "查询单个用户信息")
    public Result getTeacher(@PathVariable String id) {
        User byId = userService.getById(id);
        return ResultGenerator.success(byId);
    }

    @PostMapping("update")
    @ApiOperation(value = "修改用户信息",notes = "修改用户的信息")
    public Result update(@RequestBody User user) {
        user.setUpdateTime(DateUtil.now());
        boolean update = userService.updateById(user);
        if (update){
            return ResultGenerator.success();
        }else {
            return ResultGenerator.fail("修改失败");
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户信息",notes = "删除用户的信息，逻辑删除")
    public Result delete(@PathVariable String id) {
        User user = userService.getById(id);
        user.setIsDelete("1");
        boolean update = userService.updateById(user);
        if (update){
            return ResultGenerator.success();
        }else {
            return ResultGenerator.fail("删除失败");
        }
    }
}
