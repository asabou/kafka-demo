package com.rurbisservices.demo.kafka.producer.abstracts;

public interface SpringBootKafkaProducerServiceInterface<T> {
    void produceMessageAsync(T schema);
    void produceMessageSync(T schema);
}
