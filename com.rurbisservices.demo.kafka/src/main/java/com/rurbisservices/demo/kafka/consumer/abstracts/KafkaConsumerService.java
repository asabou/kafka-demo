package com.rurbisservices.demo.kafka.consumer.abstracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public abstract class KafkaConsumerService<T> {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    private String topic;
    private Class<T> classType;

    public KafkaConsumerService(String topic, Class<T> classType) {
        this.topic = topic;
        this.classType = classType;
    }

    /**
     * The poll method is a blocking call that fetches records from the subscribed Kafka topics.
     * It returns a ConsumerRecords object, which is a collection of records that were received during the polling interval.
     */
    public void consume() {
        try (Consumer<String, String> consumer = new KafkaConsumer<>(AppProperties.loadProperties())) {
            log.info("Subscribing to topic: {}", topic);
            consumer.subscribe(Collections.singleton(topic));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                log.info("In loop ...");
                //TODO: check if somehow kafka consumer can consume messages from a defined offset
                //      with other words, check if messages produced before starting the consumer can be consumed
                //      right now, the producer and consumer must run simultaneously in order to see how the messages are consumed
                records.forEach(record -> {
                    consumeMessage(record.key(), deserializeMessage(record.value()));
                });
            }
        } catch (Exception e) {
            log.error("Exception when trying to consume: {}", e.getMessage());
        }
    }

    /**
     * @param key     String: since the kafka records were created with no key, it will be empty or null
     * @param message T
     */
    public abstract void consumeMessage(String key, T message);

    private T deserializeMessage(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(message, classType);
        } catch (Exception e) {
            log.error("Exception when deserializing object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}