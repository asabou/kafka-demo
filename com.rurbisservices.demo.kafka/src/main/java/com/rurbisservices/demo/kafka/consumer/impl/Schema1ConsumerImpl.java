package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schema1ConsumerImpl extends KafkaConsumerService<CustomSchema1> {
    private static final Logger log = LoggerFactory.getLogger(Schema1ConsumerImpl.class);
    public Schema1ConsumerImpl(String topic, Class<CustomSchema1> classType) {
        super(topic, classType);
    }
    @Override
    public void consumeMessage(String key, CustomSchema1 message) {
        log.info("Consuming message: {}", message);
    }
}
