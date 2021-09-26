package com.github.hero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.hero.mapper.VideoMapper;
import com.github.hero.pojo.MovieVideo;
import com.github.hero.service.IVideoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, MovieVideo> implements IVideoService {

}
