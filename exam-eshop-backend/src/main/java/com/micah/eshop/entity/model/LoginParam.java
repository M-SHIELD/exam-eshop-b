package com.micah.eshop.entity.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import org.hibernate.validator.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户登录模型
 */
@ApiModel(
        value = "LoginParam (用户登录查询参数)",
        description = "用户登录查询参数"
)
@Getter
@Setter
public class LoginParam implements Serializable {

    @NotBlank(message = "用户名必填")
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码必填")
    private String password;

    public String getPassword() {
        if (password!=null){
            String psd = DigestUtils.md5DigestAsHex(password.getBytes());
            return psd;
        }else {
            return password;
        }

    }
}
