package com.micah.eshop.util.module.customizeserializer;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 转化金额位数的工具类
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

    public BigDecimalSerializer() {
    }

    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StrUtil.hasBlank(bigDecimal.toString())) {
            jsonGenerator.writeString(bigDecimal + "");
        } else {
            DecimalFormat df2 = new DecimalFormat("0.00");
            jsonGenerator.writeString(df2.format(bigDecimal));
        }
    }
}
