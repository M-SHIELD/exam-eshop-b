package com.micah.goods_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class GoodsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsExampleApplication.class, args);
    }

}
