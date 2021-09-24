package com.github.hero.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.hero.common.ResultCode;
import com.github.hero.handler.LolException;
import com.github.hero.mapper.MovieMapper;
import com.github.hero.pojo.Movie;
import com.github.hero.pojo.MovieDescription;
import com.github.hero.pojo.MovieInfoVo;
import com.github.hero.service.IMovieDescriptionService;
import com.github.hero.service.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements IMovieService {

    //课程描述注入
    @Autowired
    private IMovieDescriptionService movieDescriptionService;

    //添加课程基本信息的方法
    @Override
    public String saveCourseInfo(MovieInfoVo movieInfoVo) {
        //1 向课程表添加课程基本信息
        //CourseInfoVo对象转换eduCourse对象
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieInfoVo,movie);
        movie.setCreateTime(DateUtil.now());
        int insert = baseMapper.insert(movie);
        if(insert == 0) {
            //添加失败
            throw new LolException(ResultCode.FAIL,"添加视频信息失败");
        }

        //获取添加之后课程id
        String id = movie.getId();

        //2 向课程简介表添加课程简介
        //edu_course_description
        MovieDescription movieDescription = new MovieDescription();
        movieDescription.setDescription(movieInfoVo.getDescription());
        //设置描述id就是课程id
        movieDescription.setMovieId(id);
        movieDescription.setCreateTime(DateUtil.now());
        movieDescriptionService.save(movieDescription);
        return String.valueOf(id);
    }
}
