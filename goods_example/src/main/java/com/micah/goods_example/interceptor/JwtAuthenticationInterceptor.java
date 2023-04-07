package com.micah.goods_example.interceptor;


import com.alibaba.fastjson.JSON;

import com.micah.goods_example.enums.AppHttpCodeEnum;
import com.micah.goods_example.util.JwtUtil;
import com.micah.goods_example.util.ResponseResult;
import com.micah.goods_example.util.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Value("${tokenMark}")
    private String tokenMake;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
        log.debug(request.getServletPath());
        // 跨域的预检请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            log.info("如果不是映射到方法直接通过");
            return true;
        }

        try {
            //重请求头中获取 token
            String token = request.getHeader(tokenMake);
            // 执行认证
            if (token == null) {
                //HttpServletResponse.SC_UNAUTHORIZED 可以获取一些响应码
                //封装返回数据
                WebUtils.renderString(response, JSON.toJSONString(ResponseResult.errorResult(AppHttpCodeEnum.NO_TOKEN_OPERATE)));
                return false;
            }

            // 验证 token
            boolean ifJWT = JwtUtil.isExpiredJWT(token);
            if (ifJWT) {
                return true;
            } else {
                //封装返回数据
                WebUtils.renderString(response, JSON.toJSONString(ResponseResult.errorResult(AppHttpCodeEnum.TOKEN_ILLEGAL)));
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }
}

