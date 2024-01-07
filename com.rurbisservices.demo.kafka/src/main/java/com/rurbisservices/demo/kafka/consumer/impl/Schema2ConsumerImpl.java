package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schema2ConsumerImpl extends KafkaConsumerService<CustomSchema2> {

    private static final Logger log = LoggerFactory.getLogger(Schema2ConsumerImpl.class);
    public Schema2ConsumerImpl(String topic, Class<CustomSchema2> classType) {
        super(topic, classType);
    }

    @Override
    public void consumeMessage(String key, CustomSchema2 message) {
        log.info("Consume message: {}", message);
    }
}
