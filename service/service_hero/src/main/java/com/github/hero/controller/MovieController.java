package com.github.hero.controller;


import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.MovieInfoVo;
import com.github.hero.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class MovieController {

    @Autowired
    private IMovieService movieService;

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public Result addCourseInfo(@RequestBody MovieInfoVo movieInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = movieService.saveCourseInfo(movieInfoVo);
        return ResultGenerator.success(id);
    }
}

