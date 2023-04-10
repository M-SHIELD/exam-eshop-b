package com.micah.eshop.handler;



import com.micah.eshop.enums.AppHttpCodeEnum;
import com.micah.eshop.util.R;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 404异常
     *
     * @param e 异常信息
     * @return 404, "请求路径出错，请检查"
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public R noHandlerFoundException(NoHandlerFoundException e) {
        //打印异常信息
        log.error("出现了404异常！--->", e);
        //从异常对象中获取提示信息封装返回
        return R.init(AppHttpCodeEnum.NOT_FOUND_PAGE);
    }

    /**
     * org.hibernate.validator.constraints.NotBlank; 异常处理
     * 参数效验异常
     *
     * @param e 异常信息
     * @return 422
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R exceptionHandler(MethodArgumentNotValidException e) {
        log.error("参数效验出现了异常！---> ", e);
        //获取异常消息
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.error(AppHttpCodeEnum.REQUIRE_USERNAME.getCode(), message);
    }

    /**
     * 自定义异常
     *
     * @param e 异常信息
     * @return 自定义响应码
     */
    @ExceptionHandler(SystemException.class)
    public R systemExceptionHandler(SystemException e) {
        //打印异常信息
        log.error("出现了自定义异常！--->", e);
        //从异常对象中获取提示信息封装返回
        return R.error(e.getCode(), e.getMsg());
    }

    /**
     * 请求方式不对
     *
     * @param e 异常信息
     * @return 402
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R HttpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        //打印异常信息
        log.error("出现了请求方式不对异常！---> ", e);
        //从异常对象中获取提示信息封装返回
        return R.error(AppHttpCodeEnum.NO_TOKEN_OPERATE.getCode(), "请求方式不对");
    }

    /**
     * json解析异常
     *
     * @param e 异常信息
     * @return 422
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R exceptionHandler(HttpMessageNotReadableException e) {
        log.info("出现了json解析异常 --->", e);
        return R.error(AppHttpCodeEnum.REQUIRE_USERNAME.getCode(), "json解析异常");
    }

    /**
     * 异常兜底
     *
     * @param e 异常信息
     * @return 500
     */
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        //打印异常信息
        log.error("出现了异常兜底！ ---> ", e);
        //从异常对象中获取提示信息封装返回
        return R.error(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
