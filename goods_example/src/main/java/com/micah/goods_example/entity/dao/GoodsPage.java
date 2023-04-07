package com.micah.goods_example.entity.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页实体")
public class GoodsPage {

    @ApiModelProperty("从第几行开始")
    private Long current;

    @ApiModelProperty("一页展示多少行")
    private Long size;

    @ApiModelProperty("是否为积分商城，是为0，否为1")
    private Long isfictitious;

    @ApiModelProperty("排序方式：升序为0，降序为1")
    private Integer descOrAsc;

    @ApiModelProperty("排序列名，价格排序：price，新品排序：pid")
    private String columnName;

    @ApiModelProperty("商品分类，1家电，2服饰，3化妆品")
    private Integer categoryId;

}
