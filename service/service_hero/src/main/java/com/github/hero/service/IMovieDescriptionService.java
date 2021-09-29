package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.MovieDescription;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface IMovieDescriptionService extends IService<MovieDescription> {

    void removeByMovieId(String id);
}
