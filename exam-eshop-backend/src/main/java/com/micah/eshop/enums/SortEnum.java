package com.micah.eshop.enums;

import java.util.stream.Stream;

public enum SortEnum {
    DESC("desc", "降序"),
    ASC("asc", "升序");

    private final String value;
    private final String desc;

    SortEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public static SortEnum toType(String value) {
        return Stream.of(values()).filter((p) -> p.value.equals(value)).findAny().orElse(null);
    }
}
