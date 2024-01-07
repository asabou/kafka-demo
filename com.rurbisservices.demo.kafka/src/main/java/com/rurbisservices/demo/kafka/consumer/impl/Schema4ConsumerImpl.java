package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schema4ConsumerImpl extends KafkaConsumerService<CustomSchema4> {

    private static final Logger log = LoggerFactory.getLogger(Schema4ConsumerImpl.class);

    public Schema4ConsumerImpl(String topic, Class<CustomSchema4> classType) {
        super(topic, classType);
    }

    @Override
    public void consumeMessage(String key, CustomSchema4 message) {
        log.info("Consume message: {}", message);
    }
}