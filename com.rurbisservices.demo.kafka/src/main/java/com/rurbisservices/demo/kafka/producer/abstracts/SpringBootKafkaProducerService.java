package com.rurbisservices.demo.kafka.producer.abstracts;

import com.rurbisservices.demo.kafka.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public abstract class SpringBootKafkaProducerService<T> implements SpringBootKafkaProducerServiceInterface<T> {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private Class<T> classType;

    public SpringBootKafkaProducerService(String topic, Class<T> classType) {
        this.topic = topic;
        this.classType = classType;
    }

    @Override
    public void produceMessageAsync(T schema) {
        log.info("Trying to send message {}", schema);
        kafkaTemplate.send(topic, ServiceUtils.serializeMessage(schema));
        log.info("Message sent.");
    }

    @Override
    public void produceMessageSync(T schema) {
        log.info("Trying to send message sync {}", schema);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, ServiceUtils.serializeMessage(schema));
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Message {} sent on partition {} and offset {}", schema, result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            } else {
                log.error("Message not sent: {}", ex.getMessage());
            }
        });
    }
}
