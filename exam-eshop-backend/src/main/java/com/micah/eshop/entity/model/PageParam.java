package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName PageParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/10 16:25
 * @Version 1.0
 **/
@ApiModel(
        value = "PageParam (分页查询参数)",
        description = "分页查询参数"
)
@Getter
@Setter
public class PageParam {


    @ApiModelProperty(value = "当前数目")
    private Long current=0L;

    @ApiModelProperty(value = "查询大小")
    private Long size=0L;


}
