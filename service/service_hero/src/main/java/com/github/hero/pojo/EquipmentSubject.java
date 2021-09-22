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
@TableName("equipment_subject")
@ApiModel("装备分类实体类")
public class EquipmentSubject implements Serializable {

    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("类别名称")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty("父ID")
    @TableField(value = "parent_id")
    private String parentId;

    @ApiModelProperty("排序")
    @TableField(value = "sort")
    private String sort;
    
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private String createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time")
    private String updateTime;


}
