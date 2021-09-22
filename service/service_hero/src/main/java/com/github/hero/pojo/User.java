package com.github.hero.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
@ApiModel("用户实体类")
public class User implements Serializable {

    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("名称")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty("年龄")
    @TableField(value = "age")
    private String age;

    @ApiModelProperty("昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty("登录账号")
    @TableField(value = "login_name")
    private String loginName;

    @ApiModelProperty("登录密码")
    @TableField(value = "pass_word")
    private String passWord;

    @ApiModelProperty("头像")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty("是否删除")
    @TableField(value = "is_delete")
    private String isDelete;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private String createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time")
    private String updateTime;

    @ApiModelProperty("简介")
    @TableField(value = "description")
    private String description;
}
