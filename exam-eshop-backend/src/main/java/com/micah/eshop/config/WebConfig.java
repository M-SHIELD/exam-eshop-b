package com.micah.eshop.config;

import com.micah.eshop.interceptor.JwtAuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    //注册拦截器token拦截器
    private final JwtAuthenticationInterceptor jwtAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 拦截路径 excludePathPatterns 排除路径
        registry.addInterceptor(jwtAuthenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login") //登录
                .excludePathPatterns("/api/user/register") //注册
                .excludePathPatterns("/api/category/**") //分类
                .excludePathPatterns("/api/order/**") //
                .excludePathPatterns("/api/product/**") //
//                .excludePathPatterns("/api/wallet/**") //
                .excludePathPatterns("/doc.html")//文档地址
        ;
    }

    @Bean
    public Docket createRestApi() {
        // 文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.micah.eshop.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("micah")
                .version("1.0")
                .description("micah接口文档")
                .build();
    }

}
