package com.rurbisservices.demo.kafka.consumer;

import com.rurbisservices.demo.kafka.consumer.impl.SpringBootSchema1ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.SpringBootSchema2ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.SpringBootSchema3ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.SpringBootSchema4ConsumerImpl;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.Map;
import java.util.Properties;

@Configuration
public class SpringBootKafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Properties properties = AppProperties.loadProperties();
        Map<String, Object> configs = (Map<String, Object>) (Map) properties;
        return new DefaultKafkaConsumerFactory<>(configs);
    }

@Bean
    public ConcurrentMessageListenerContainer<String, String> listenerContainerSchema1() {
        ContainerProperties containerProperties = new ContainerProperties(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[0]);
        containerProperties.setMessageListener(new SpringBootSchema1ConsumerImpl());
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProperties);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> listenerContainerSchema2() {
        ContainerProperties containerProperties = new ContainerProperties(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[1]);
        containerProperties.setMessageListener(new SpringBootSchema2ConsumerImpl());
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProperties);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> listenerContainerSchema3() {
        ContainerProperties containerProperties = new ContainerProperties(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[2]);
        containerProperties.setMessageListener(new SpringBootSchema3ConsumerImpl());
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProperties);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> listenerContainerSchema4() {
        ContainerProperties containerProperties = new ContainerProperties(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[3]);
        containerProperties.setMessageListener(new SpringBootSchema4ConsumerImpl());
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProperties);
    }
}
