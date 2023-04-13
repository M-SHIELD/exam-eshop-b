package com.micah.eshop.util.module;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.micah.eshop.handler.SystemException;
import com.micah.eshop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static com.micah.eshop.enums.AppHttpCodeEnum.NO_OPERATOR_AUTH;

/**
 * @author Micah
 */
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
        String suid;
        try {
            suid = String.valueOf(jsonObject.get("uid"));
        } catch (NullPointerException nullPointerException) {
            throw new RuntimeException("解析token失败,可能是token已过期或错误");
        }
        return Long.valueOf(suid);
    }

    /**
     * 判断request是否有权限访问uid字段的请求
     *
     * @param request Request请求
     * @param uid     验证对象的uid字段
     */
    public static void havePermission(HttpServletRequest request, Long uid) {
        Long uid1 = getUid(request);
        boolean equals = uid1.equals(uid);
        if (!equals) {
            throw new SystemException(NO_OPERATOR_AUTH);
        }
    }

    @Autowired(required = false)
    @Value("${tokenMark}")
    public void setTokenMake(String tokenMark) {
        GetUserInfo.tokenMake = tokenMark;
    }

}
