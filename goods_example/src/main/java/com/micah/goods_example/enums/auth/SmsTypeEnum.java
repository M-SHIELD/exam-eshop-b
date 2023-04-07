
package com.micah.goods_example.enums.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 短信类型枚举
 */
@Getter
@AllArgsConstructor
public enum SmsTypeEnum {
    BIND("bind", "绑定手机短信"),
    LOGIN("login", "登陆短信"),
    REGISTER("register", "注册短信");

    private final String value;
    private final String desc;

    public static SmsTypeEnum toType(String value) {
        return Stream.of(values())
                .filter(c -> c.value.equals(value))
                .findAny()
                .orElse(null);
    }
}
