package com.micah.goods_example.entity.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.DigestUtils;


import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户登录模型
 */
@ApiModel(
        value = "RegisterParam (用户注册参数)",
        description = "用户注册参数"
)
@Getter
@Setter
public class RegisterParam implements Serializable {

    @NotBlank(message = "用户名必填")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码必填")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "邮箱必填")
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;

    @NotBlank(message = "电话必填")
    @Pattern(regexp = "^1[3-9]\\d{9}$",message = "电话号格式不对")
    @ApiModelProperty(value = "电话")
    private String phone;

    public String getPassword() {
        if (password!=null){
            String psd = DigestUtils.md5DigestAsHex(password.getBytes());
            return psd;
        }else {
            return password;
        }

    }
}
