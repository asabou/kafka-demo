package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Schema1ConsumerImpl extends KafkaConsumerService<CustomSchema1> {
    public Schema1ConsumerImpl(String topic, Class<CustomSchema1> classType) {
        super(topic, classType);
    }
    @Override
    public void consumeMessage(String key, CustomSchema1 message) {
        log.info("Consuming message: {}", message);
    }
}
