package com.micah.goods_example.enums;

/**
 * 接口响应返回枚举
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200, "操作成功"),
    REGISTER_SUCCESS(200, "注册成功", true),
    NO_REGISTER_SUCCESS(400, "注册失败", false),
    // 登录
    NEED_LOGIN(401, "需要登录后操作"),
    NO_TOKEN_OPERATE(402, "请求非法，请携带token"),
    NO_PARAMETE_OPERATE(411, "请求非法，参数错误"),
    NOT_FOUND_PAGE(404, "请求路径出错，请检查"),
    TOKEN_ILLEGAL(406, "请求非法，token无效"),
    NO_OPERATOR_AUTH(403, "无权限操作"),
    SYSTEM_ERROR(500, "出现错误"),
    FAIL(500, "操作失败"),
    USERNAME_EXIST(422, "用户名已存在"),
    PHONENUMBER_EXIST(422, "手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(422, "必需填写用户名"),
    LOGIN_ERROR(422, "用户名或密码错误", false),
    LOGIN_SUCCESS(200, "登录成功", true),
    FILE_TYPE_ERROR(506, "文件类型出错");

    final int code;
    final String msg;
    final boolean success;

    AppHttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
        this.success = true;
    }

    AppHttpCodeEnum(int code, String errorMessage, boolean success) {
        this.code = code;
        this.msg = errorMessage;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }
}
