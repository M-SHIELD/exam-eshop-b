package com.micah.eshop.util.module;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.micah.eshop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class GetUserInfo {

    @Value("${tokenMark}")
    private static String tokenMake;

    /**
     * 从token获取用户ID
     *
     * @return 用户ID
     */
    public static Long getUid(HttpServletRequest request) {
        /*从本地获取user uid*/
        String token = request.getHeader(tokenMake);
        String sub = JwtUtil.getSub(token);
        JSONObject jsonObject = JSON.parseObject(sub);

        String suid = "";
        try {
            suid = String.valueOf(jsonObject.get("uid"));
        } catch (NullPointerException nullPointerException) {
            throw new RuntimeException("解析token失败,可能是token已过期或错误");
        }


        return Long.valueOf(suid);
    }

    @Autowired(required = false)
    @Value("${tokenMark}")
    public void setTokenMake(String tokenMark) {
        GetUserInfo.tokenMake = tokenMark;
    }

}
