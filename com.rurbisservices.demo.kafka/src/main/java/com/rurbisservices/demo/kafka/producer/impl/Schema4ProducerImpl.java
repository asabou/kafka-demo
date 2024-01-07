package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.KafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;

public class Schema4ProducerImpl extends KafkaProducerService<CustomSchema4> {
    public Schema4ProducerImpl(String topic, Class<CustomSchema4> classType) {
        super(topic, classType);
    }
}
