package com.rurbisservices.demo.kafka.consumer.impl;

import com.rurbisservices.demo.kafka.consumer.abstracts.KafkaConsumerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Schema2ConsumerImpl extends KafkaConsumerService<CustomSchema2> {

    public Schema2ConsumerImpl(String topic, Class<CustomSchema2> classType) {
        super(topic, classType);
    }

    @Override
    public void consumeMessage(String key, CustomSchema2 message) {
        log.info("Consume message: {}", message);
    }
}
