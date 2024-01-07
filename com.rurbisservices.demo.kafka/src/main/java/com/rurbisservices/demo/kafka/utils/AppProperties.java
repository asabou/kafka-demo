package com.rurbisservices.demo.kafka.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final Logger log = LoggerFactory.getLogger(AppProperties.class);
    private static Properties properties = null;

    public static Properties loadProperties() throws IOException {
        if (properties == null) {
            properties = new Properties();
            try (InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream("kafka-app.properties")) {
                properties.load(inputStream);
            } catch (IOException e) {
                log.error("Exception when trying to load properties");
                throw e;
            }
        }
        return properties;
    }
}

