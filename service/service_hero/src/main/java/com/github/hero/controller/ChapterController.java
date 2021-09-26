package com.github.hero.controller;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.ChapterVo;
import com.github.hero.pojo.MovieChapter;
import com.github.hero.service.IChapterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@RestController
@RequestMapping("/chapter")
@Api(tags = "章节管理")
@CrossOrigin
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    //课程大纲列表,根据课程id进行查询
    @GetMapping("getChapterVideo/{movieId}")
    public Result getChapterVideo(@PathVariable String movieId) {
        List<ChapterVo> list = chapterService.getChapterVideoByMovieId(movieId);
        return ResultGenerator.success(list);
    }

    //添加章节
    @PostMapping("addChapter")
    public Result addChapter(@RequestBody MovieChapter movieChapter) {
        movieChapter.setCreateTime(DateUtil.now());
        chapterService.save(movieChapter);
        return ResultGenerator.success();
    }

    //根据章节id查询
    @GetMapping("getChapterInfo/{chapterId}")
    public Result getChapterInfo(@PathVariable String chapterId) {
        MovieChapter eduChapter = chapterService.getById(chapterId);
        return ResultGenerator.success(eduChapter);
    }

    //修改章节
    @PostMapping("updateChapter")
    public Result updateChapter(@RequestBody MovieChapter eduChapter) {
        eduChapter.setUpdateTime(DateUtil.now());
        chapterService.updateById(eduChapter);
        return ResultGenerator.success();
    }

    //删除的方法
    @DeleteMapping("{chapterId}")
    public Result deleteChapter(@PathVariable String chapterId) {
        boolean flag = chapterService.deleteChapter(chapterId);
        if(flag) {
            return ResultGenerator.success();
        } else {
            return ResultGenerator.fail("删除失败");
        }

    }
}

