package com.github.hero.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageQuery extends Page {

    //父类current为当前页
    //父类size为每页条数
    //父类total为总条数
    //父类records为数据
    //查询参数key
    private String key;
    //查询参数值
    private String value;
}
