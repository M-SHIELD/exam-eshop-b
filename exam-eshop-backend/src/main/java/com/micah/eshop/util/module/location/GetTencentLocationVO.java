package com.micah.eshop.util.module.location;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("腾讯地图返回对象")
@Data
public class GetTencentLocationVO implements Serializable {
    @ApiModelProperty("地址解析结果")
    private ResultBean result;
    @ApiModelProperty("状态说明")
    private String message;
    @ApiModelProperty("状态码，0为正常")
    private Integer status;

    @ApiModel("地址解析结果")
    @Data
    public static class ResultBean {
        @ApiModelProperty("解析到的坐标")
        private LocationBean location;
        @ApiModelProperty("解析精度级别，分为11个级别，一般>=9即可采用（定位到点，精度较高） 也可根据实际业务需求自行调整")
        private int level;
        @ApiModelProperty("即将下线，由reliability代替")
        private double similarity;
        @ApiModelProperty("行政区划信息")
        private AdInfoBean ad_info;
        @ApiModelProperty("可信度参考")
        private int reliability;
        @ApiModelProperty("即将下线，由level代替")
        private int deviation;
        @ApiModelProperty("区信息")
        private String title;
        @ApiModelProperty("行政区划信息")
        private AddressComponentsBean address_components;

        @ApiModel("解析到的坐标")
        @Data
        public static class LocationBean {
            @ApiModelProperty("经度")
            private double lng;
            @ApiModelProperty("纬度")
            private double lat;
        }

        @Data
        @ApiModel("行政区划信息")
        public static class AdInfoBean {
            @ApiModelProperty("行政区划代码")
            private String adcode;
        }

        @Data
        @ApiModel("解析后的地址部件")
        public static class AddressComponentsBean {
            @ApiModelProperty("省")
            private String province;
            @ApiModelProperty("市")
            private String city;
            @ApiModelProperty("街道，可能为空字串")
            private String street;
            @ApiModelProperty("区，可能为空字串")
            private String district;
            @ApiModelProperty("门牌，可能为空字串")
            private String street_number;
        }
    }
}
