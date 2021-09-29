package com.github.hero.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("影视条件查询类")
public class MovieQuery implements Serializable {

    @ApiModelProperty("名称")
    private String title;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("创建时间开始")
    private String createTimeStart;

    @ApiModelProperty("创建时间结束")
    private String createTimeEnd;
}
