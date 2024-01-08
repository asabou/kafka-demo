package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.SpringBootKafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringBootSchema1ConsumerImpl extends SpringBootKafkaConsumerService<CustomSchema1> {
    public SpringBootSchema1ConsumerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[0], CustomSchema1.class);
    }

    @Override
    public void consume(CustomSchema1 schema) {
        log.info("Consuming message {}", schema);
    }
}
