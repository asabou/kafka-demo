package com.rurbisservices.demo.kafka.utils;

import java.util.Random;

public class ServiceUtils {
    public static short convertStringToShort(String string) {
        return Short.parseShort(string);
    }

    public static int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@!#@#$%$^&*&()_+{}|:\"<>?";
        StringBuilder randomString = new StringBuilder();
        int length = getRandomInt(20);
        for (int i = 0; i < length; i++) {
            int index = getRandomInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    public static int getRandomInt(int length) {
        return new Random().nextInt(length);
    }
}
