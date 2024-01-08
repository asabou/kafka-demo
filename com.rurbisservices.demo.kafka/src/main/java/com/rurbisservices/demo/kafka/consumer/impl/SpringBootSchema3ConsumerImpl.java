package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.SpringBootKafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringBootSchema3ConsumerImpl extends SpringBootKafkaConsumerService<CustomSchema3> {
    public SpringBootSchema3ConsumerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[1], CustomSchema3.class);
    }

    @Override
    public void consume(CustomSchema3 schema) {
        log.info("Consuming message {}", schema);
    }
}
