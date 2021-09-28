package com.github.hero.controller;

import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import com.github.hero.pojo.MovieVideo;
import com.github.hero.service.IVideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 视频
 */
@RestController
@RequestMapping("/video")
@Api(tags = "视频video管理")
@CrossOrigin
public class VideoController {

    @Autowired
    private IVideoService videoService;

    //添加小节
    @PostMapping("addVideo")
    public Result addVideo(@RequestBody MovieVideo eduVideo) {
        videoService.save(eduVideo);
        return ResultGenerator.success();
    }

    //删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public Result deleteVideo(@PathVariable String id) {
        videoService.removeById(id);
        return ResultGenerator.success();
    }

    //修改小节 TODO

}

