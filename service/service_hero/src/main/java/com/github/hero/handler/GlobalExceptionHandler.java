package com.github.hero.handler;

import com.github.hero.common.Result;
import com.github.hero.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @param e
     * @return Result
     * @description
     * Exception指定为具体的异常类型，即可拦截指定异常并返回
     * 优先拦截并返回执行异常，若没有指定异常，则返回Exception异常拦截
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public Result error(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return ResultGenerator.fail("系统异常，请联系管理员");
    }

    /**
     *
     * @param e
     * @return Result
     * @description
     * 自定义异常处理器
     */
    @ExceptionHandler(LolException.class)
    @ResponseBody //为了返回数据
    public Result error(LolException e) {
        log.error(e.getMsg());
        e.printStackTrace();
        return ResultGenerator.fail(e.getCode(),e.getMessage());
    }
}
