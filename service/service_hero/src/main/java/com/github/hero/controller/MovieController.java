package com.github.hero.controller;


import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.Movie;
import com.github.hero.pojo.MovieInfoVo;
import com.github.hero.pojo.PublishVo;
import com.github.hero.service.IMovieService;
import io.swagger.annotations.Api;
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
@RequestMapping("/movie")
@Api(tags = "影视管理")
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

    //根据课程id查询影视基本信息
    @GetMapping("getMovieInfo/{movieId}")
    public Result getCourseInfo(@PathVariable String movieId) {
        MovieInfoVo movieInfo = movieService.getMovieInfo(movieId);
        return ResultGenerator.success(movieInfo);
    }

    //修改影视信息
    @PostMapping("updateMovieInfo")
    public Result updateMovieInfo(@RequestBody MovieInfoVo movieInfoVo) {
        movieService.updateMovieInfo(movieInfoVo);
        return ResultGenerator.success();
    }

    //根据课程id查询影视基本信息
    @GetMapping("getPublishVo/{id}")
    public Result getPublishVo(@PathVariable String id) {
        PublishVo publishVo = movieService.getPublishVo(id);
        return ResultGenerator.success(publishVo);
    }

    //修改影视信息
    @PostMapping("publishMovie/{id}")
    public Result publishMovie(@PathVariable String id) {
        Movie movie = new Movie();
        movie.setId(id);
        //已发布
        movie.setStatus("Normal");
        movieService.updateById(movie);
        return ResultGenerator.success();
    }
}

