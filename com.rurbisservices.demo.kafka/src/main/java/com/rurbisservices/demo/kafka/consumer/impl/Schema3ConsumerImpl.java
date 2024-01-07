package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schema3ConsumerImpl extends KafkaConsumerService<CustomSchema3> {

    private static final Logger log = LoggerFactory.getLogger(Schema3ConsumerImpl.class);

    public Schema3ConsumerImpl(String topic, Class<CustomSchema3> classType) {
        super(topic, classType);
    }

    @Override
    public void consumeMessage(String key, CustomSchema3 message) {
        log.info("Consume message: {}", message);
    }
}