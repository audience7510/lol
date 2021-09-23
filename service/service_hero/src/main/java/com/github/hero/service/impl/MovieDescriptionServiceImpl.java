package com.github.hero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.hero.mapper.MovieDescriptionMapper;
import com.github.hero.pojo.MovieDescription;
import com.github.hero.service.IMovieDescriptionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@Service
public class MovieDescriptionServiceImpl extends ServiceImpl<MovieDescriptionMapper, MovieDescription> implements IMovieDescriptionService {

}
