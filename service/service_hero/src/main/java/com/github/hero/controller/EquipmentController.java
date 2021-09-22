package com.github.hero.controller;

import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.OneSubject;
import com.github.hero.service.IEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("equipment")
@Api(tags = "装备管理")
@CrossOrigin
public class EquipmentController {


    @Autowired
    IEquipmentService equipmentService;

    //获取上传过来文件，把文件内容读取出来
    @PostMapping("addSubject")
    @ApiOperation(value = "装备分类excel上传",notes = "上传一级分类和二级分类的装备")
    public Result addSubject(MultipartFile file) {
        equipmentService.addSubject(file,equipmentService);
        return ResultGenerator.success();
    }

    //获取上传过来文件，把文件内容读取出来
    @GetMapping("list")
    @ApiOperation(value = "树形列表",notes = "一级分类和二级分类的装备树形列表")
    public Result getAllOneTwoSubject() {
        List<OneSubject> list = equipmentService.getAllOneTwoSubject();
        return ResultGenerator.success(list);
    }
}
