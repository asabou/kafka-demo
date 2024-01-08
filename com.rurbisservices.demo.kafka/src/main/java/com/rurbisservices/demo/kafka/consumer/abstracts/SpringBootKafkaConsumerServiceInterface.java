package com.rurbisservices.demo.kafka.consumer.abstracts;

public interface SpringBootKafkaConsumerServiceInterface<T> {
    void consume(T schema);
}
