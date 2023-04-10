package com.micah.eshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan("com.micah.eshop.dao")
public class GoodsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsExampleApplication.class, args);
    }

}
