package com.micah.eshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 商品信息表
    */
@ApiModel(description="商品信息表")
@Schema(description="商品信息表")
public class EProductEntity {
    /**
    * 自增主键
    */
    @ApiModelProperty(value="自增主键")
    @Schema(description="自增主键")
    private Long id;

    /**
    * 商品名称
    */
    @ApiModelProperty(value="商品名称")
    @Schema(description="商品名称")
    private String name;

    /**
    * 商品图片
    */
    @ApiModelProperty(value="商品图片")
    @Schema(description="商品图片")
    private String image;

    /**
    * 商品预览图片
    */
    @ApiModelProperty(value="商品预览图片")
    @Schema(description="商品预览图片")
    private String sliderImage;

    /**
    * 商品描述
    */
    @ApiModelProperty(value="商品描述")
    @Schema(description="商品描述")
    private String description;

    /**
    * 商品分类ID
    */
    @ApiModelProperty(value="商品分类ID")
    @Schema(description="商品分类ID")
    private Long categoryId;

    /**
    * 商品价格
    */
    @ApiModelProperty(value="商品价格")
    @Schema(description="商品价格")
    private BigDecimal price;

    /**
    * 商品库存
    */
    @ApiModelProperty(value="商品库存")
    @Schema(description="商品库存")
    private Integer stock;

    /**
    * 商品销量
    */
    @ApiModelProperty(value="商品销量")
    @Schema(description="商品销量")
    private Integer sales;

    /**
    * 是否展示
    */
    @ApiModelProperty(value="是否展示")
    @Schema(description="是否展示")
    private Boolean isShow;

    /**
    * 是否热门
    */
    @ApiModelProperty(value="是否热门")
    @Schema(description="是否热门")
    private Boolean isHot;

    /**
    * 是否为积分商品，0表示不是，1表示是
    */
    @ApiModelProperty(value="是否为积分商品，0表示不是，1表示是")
    @Schema(description="是否为积分商品，0表示不是，1表示是")
    private Boolean isIntegral;

    /**
    * 所需积分
    */
    @ApiModelProperty(value="所需积分")
    @Schema(description="所需积分")
    private Long integral;

    /**
    * 商品状态，0：下架，1：在售
    */
    @ApiModelProperty(value="商品状态，0：下架，1：在售")
    @Schema(description="商品状态，0：下架，1：在售")
    private Boolean status;

    /**
    * 商品创建时间
    */
    @ApiModelProperty(value="商品创建时间")
    @Schema(description="商品创建时间")
    private Date createTime;

    /**
    * 商品更新时间
    */
    @ApiModelProperty(value="商品更新时间")
    @Schema(description="商品更新时间")
    private Date updateTime;

    /**
    * 是否删除，0：否，1：是
    */
    @ApiModelProperty(value="是否删除，0：否，1：是")
    @Schema(description="是否删除，0：否，1：是")
    private Boolean isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(String sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsIntegral() {
        return isIntegral;
    }

    public void setIsIntegral(Boolean isIntegral) {
        this.isIntegral = isIntegral;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}