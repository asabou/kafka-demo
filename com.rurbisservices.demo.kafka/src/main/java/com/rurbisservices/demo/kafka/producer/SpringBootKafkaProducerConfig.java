package com.rurbisservices.demo.kafka.producer;

import com.rurbisservices.demo.kafka.utils.AppProperties;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.*;

@Configuration
public class SpringBootKafkaProducerConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Properties properties = AppProperties.loadProperties();
        Map<String, Object> configs = (Map<String, Object>) (Map) properties;
        return new KafkaAdmin(configs);
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfigurationProperties());
    }

    //We can have custom messages (eg. ProducerFactory<String, CustomSchema1>)
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Properties properties = AppProperties.loadProperties();
        Map<String, Object> configs = (Map<String, Object>) (Map) properties;
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
