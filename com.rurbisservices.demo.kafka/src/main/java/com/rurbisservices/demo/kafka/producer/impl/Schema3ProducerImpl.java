package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.KafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;

public class Schema3ProducerImpl extends KafkaProducerService<CustomSchema3> {
    public Schema3ProducerImpl(String topic, Class<CustomSchema3> classType) {
        super(topic, classType);
    }
}
