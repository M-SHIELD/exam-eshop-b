package com.micah.goods_example.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micah.goods_example.enums.AppHttpCodeEnum;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回数据格式
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private static final Date date = new Date();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String msg;
    private T data;
    private Integer status;
    private boolean success;
    private String time;

    private ResponseResult() {
        this.status = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
        this.success = true;
        this.time = simpleDateFormat.format(date);
    }

    private ResponseResult(Integer status, boolean success, String msg, T data) {
        this.status = status;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }


    private ResponseResult(Integer status, boolean success, String msg, T data, String time) {
        this.status = status;
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.time = time;
    }

    /************/
    //返回成功
    public static ResponseResult okResult() {
        return new ResponseResult();
    }


    //返回失败的错误信息 TODO 最后将fail 改为 failResult
    public static ResponseResult<String> fail(String message) {
        return new ResponseResult(AppHttpCodeEnum.FAIL.getCode(), false, message, (Object) null);
    }

    //返回自定义失败响应码，和提示信息
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    /*****计划移除*****/
    //TODO 计划移除
    //返回成功，数据不为空是带数据返回
    public static ResponseResult okResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getMsg());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    /*** 计划移除end ****/


    //返回成功响应码，和提示信息,和数据
    public static ResponseResult okResult(int code, String msg, Object data) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, data, msg);
    }

    //返回自定义成功枚举，数据未空
    public static ResponseResult okResult(int code, String msg) {
        Map data = new HashMap();
        ResponseResult result = new ResponseResult();
        return result.ok(code, data, msg);
    }

    //枚举封装错误信息，和数据
    public static ResponseResult errorResult(AppHttpCodeEnum enums) {
//        return setAppHttpCodeEnum(enums, enums.getMsg());
        return errorResult(enums.getCode(), enums.getMsg());
    }

    //枚举封装成功信息，和数据
    public static ResponseResult okResult(AppHttpCodeEnum enums, Object data) {
//        return setAppHttpCodeEnum(enums, enums.getMsg());
        return okResult(enums.getCode(), enums.getMsg(), data);
    }

    //枚举封装成功信息，数据为空
    public static ResponseResult okResult(AppHttpCodeEnum enums) {
        return okResult(enums.getCode(), enums.getMsg());
    }

    //设置信息
    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums) {
        return okResult(enums.getCode(), enums.getMsg());
    }

    //设置信息，加自定义提示
    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg) {
        return okResult(enums.getCode(), msg);
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.status = code;
        this.msg = msg;
        this.success = false;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.status = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.status = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
