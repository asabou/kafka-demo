package com.rurbisservices.demo.kafka.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class AppProperties {

    private static Properties properties = null;

    public static Properties loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream("kafka-app.properties")) {
                properties.load(inputStream);
            } catch (IOException e) {
                log.error("Exception when trying to load properties");
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
}

