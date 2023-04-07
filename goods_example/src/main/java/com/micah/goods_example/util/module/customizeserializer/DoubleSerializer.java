package com.micah.goods_example.util.module.customizeserializer;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 转化金额位数的工具类
 */
public class DoubleSerializer extends JsonSerializer<Double> {
    public DoubleSerializer() {
    }

    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (StrUtil.hasBlank(value.toString())) {
            gen.writeString(value + "");
        } else {
            DecimalFormat df2 = new DecimalFormat("0.00");
            gen.writeString(df2.format(value));
        }

    }
}
