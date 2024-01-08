package com.rurbisservices.demo.kafka.consumer.abstracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import com.rurbisservices.demo.kafka.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public abstract class KafkaConsumerService<T> {

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
            Properties properties = AppProperties.loadProperties();
            int noKafkaMessagesToConsume = ServiceUtils.convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_NUMBER_OF_MESSAGES));
            int noKafkaMessagesConsumed = 0;
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                log.info("In loop ...");
                records.forEach(record -> {
                    consumeMessage(record.key(), ServiceUtils.deserializeMessage(record.value(), classType));
                });
                noKafkaMessagesConsumed += records.count();
                if (noKafkaMessagesConsumed >= noKafkaMessagesToConsume) {
                    break;
                }
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

}
