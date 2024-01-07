package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.KafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;

public class Schema2ProducerImpl extends KafkaProducerService<CustomSchema2> {
    public Schema2ProducerImpl(String topic, Class<CustomSchema2> classType) {
        super(topic, classType);
    }
}
