package com.github.hero.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.hero.pojo.Movie;
import com.github.hero.pojo.PublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface MovieMapper extends BaseMapper<Movie> {

    PublishVo getPublishVo(String id);
}
