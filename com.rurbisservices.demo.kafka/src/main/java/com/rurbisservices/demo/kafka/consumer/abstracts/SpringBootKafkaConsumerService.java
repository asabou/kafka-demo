package com.rurbisservices.demo.kafka.consumer.abstracts;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerServiceInterface;
import com.rurbisservices.demo.kafka.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class SpringBootKafkaConsumerService<T> implements SpringBootKafkaConsumerServiceInterface<T>, MessageListener<String, String> {
    private String topic;

    private Class<T> classType;

    public SpringBootKafkaConsumerService(String topic, Class<T> classType) {
        this.topic = topic;
        this.classType = classType;
    }

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        log.info("Topic: {} Metadata: partition {}, offset {}", topic, data.partition(), data.offset());
        T schema = ServiceUtils.deserializeMessage(data.value(), classType);
        consume(schema);
    }
}
