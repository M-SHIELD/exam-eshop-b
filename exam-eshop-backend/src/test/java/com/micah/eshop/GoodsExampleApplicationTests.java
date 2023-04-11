package com.micah.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GoodsExampleApplicationTests {

    @Test
    void contextLoads() {
        //斐波那契数列
        System.out.println(fibonacci(10));


    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
