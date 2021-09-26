package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.Movie;
import com.github.hero.pojo.MovieInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface IMovieService extends IService<Movie> {

    //添加课程基本信息的方法
    String saveCourseInfo(MovieInfoVo movieInfoVo);

    MovieInfoVo getMovieInfo(String movieId);

    void updateMovieInfo(MovieInfoVo movieInfoVo);
}
