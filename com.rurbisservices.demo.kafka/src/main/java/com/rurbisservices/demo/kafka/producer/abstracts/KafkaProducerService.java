package com.rurbisservices.demo.kafka.producer.abstracts;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.KafkaUtils;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class KafkaProducerService<T> {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    private String topic;
    private Class<T> classType;

    public KafkaProducerService(String topic, Class<T> classType) {
        this.topic = topic;
        this.classType = classType;
    }

    public void produce(T schema) {
        ProducerRecord<String, String> record = getProducerRecord(topic, schema);
        log.info("Produce topic={}, message={}", topic, record.value());
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(AppProperties.loadProperties());
             AdminClient adminClient = AdminClient.create(AppProperties.loadProperties())) {
            if (KafkaUtils.topicExists(adminClient, topic)) {
                log.info("record send start");
                //TODO: we need to produce record synchronous because we need its metadata
                RecordMetadata recordMetadata = producer.send(record).get();
                log.info("record sent. record value = {} ; partition = {}, offset = {}", record.value(), recordMetadata.partition(), recordMetadata.offset());
                producer.flush();
            } else {
                log.warn("Topic does not exists");
            }
        } catch (Exception e) {
            log.error("Exception when trying to produce message: {}", e.getMessage());
        }
    }

    private ProducerRecord<String, String> getProducerRecord(String topic, T schema) {
        log.info("Getting the ProducerRecord ...");
        final String message = serializeMessage(schema);
        return new ProducerRecord<>(topic, message);
    }

    private String serializeMessage(T object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error when serializing object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
