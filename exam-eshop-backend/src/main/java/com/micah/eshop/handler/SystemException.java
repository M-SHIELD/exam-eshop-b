package com.micah.eshop.handler;


import com.micah.eshop.enums.AppHttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 自定义异常类
 */
public class SystemException extends RuntimeException {

    private int code;

    private String msg;

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum, String msg) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = msg;
    }
}
