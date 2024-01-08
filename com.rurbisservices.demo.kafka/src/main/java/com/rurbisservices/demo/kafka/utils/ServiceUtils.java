package com.rurbisservices.demo.kafka.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
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

    public static <T> String serializeMessage(T object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error when serializing object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserializeMessage(String message, Class<T> classType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(message, classType);
        } catch (Exception e) {
            log.error("Exception when deserializing object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
