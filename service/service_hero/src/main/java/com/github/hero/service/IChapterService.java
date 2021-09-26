package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.ChapterVo;
import com.github.hero.pojo.MovieChapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface IChapterService extends IService<MovieChapter> {

    //课程大纲列表,根据课程id进行查询
    List<ChapterVo> getChapterVideoByMovieId(String movieId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);
}
