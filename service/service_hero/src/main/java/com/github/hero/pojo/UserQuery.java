package com.github.hero.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户条件查询类")
public class UserQuery implements Serializable {

    @ApiModelProperty("名称，模糊查询")
    private String userName;

    @ApiModelProperty("昵称，模糊查询")
    private String nickName;

    @ApiModelProperty("创建时间开始")
    private String createTimeStart;

    @ApiModelProperty("创建时间结束")
    private String createTimeEnd;
}
