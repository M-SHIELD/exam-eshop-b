package com.micah.eshop.enums;

/**
 * 用户注册接口枚举
 */
public enum AppFromEnum {

    WEIXIN_H5("weixinh5", "weixinh5"),
    H5("h5", "H5"),
    WECHAT("wechat", "公众号"),
    APP("app", "APP"),
    ROUNTINE("routine", "小程序"),
    UNIAPPH5("uniappH5", "uniappH5");

    private final String value;
    private final String desc;

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    AppFromEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }
}
