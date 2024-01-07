package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.KafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;

public class Schema1ProducerImpl extends KafkaProducerService<CustomSchema1> {
    public Schema1ProducerImpl(String topic, Class<CustomSchema1> classType) {
        super(topic, classType);
    }
}
