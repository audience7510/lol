package com.github.hero.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovieInfoVo {
    @ApiModelProperty(value = "视频ID")
    private String id;

    @ApiModelProperty(value = "作者ID")
    private String teacherId;

    @ApiModelProperty(value = "分类ID")
    private String subjectId;

    @ApiModelProperty(value = "分类ID")
    private String subjectParentId;

    @ApiModelProperty(value = "视频标题")
    private String title;

    @ApiModelProperty(value = "视频销售价格，设置为0则可免费观看")
    // 0.01
    private BigDecimal price;

    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "视频封面图片路径")
    private String cover;

    @ApiModelProperty(value = "视频简介")
    private String description;
}
