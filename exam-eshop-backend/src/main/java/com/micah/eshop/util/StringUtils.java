package com.micah.eshop.util;

import java.util.Random;

/**
 * @ClassName StringUtils
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/9 14:37
 * @Version 1.0
 **/
public class StringUtils {

    public static String generateRandomLetters(int length) {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }
}
