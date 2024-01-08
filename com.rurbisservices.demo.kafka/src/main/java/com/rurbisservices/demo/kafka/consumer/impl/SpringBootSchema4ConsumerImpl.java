package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.SpringBootKafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringBootSchema4ConsumerImpl extends SpringBootKafkaConsumerService<CustomSchema4> {
    public SpringBootSchema4ConsumerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[1], CustomSchema4.class);
    }

    @Override
    public void consume(CustomSchema4 schema) {
        log.info("Consuming message {}", schema);
    }
}
