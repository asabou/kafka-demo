package com.rurbisservices.demo.kafka.topics;

import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import com.rurbisservices.demo.kafka.utils.KafkaUtils;
import com.rurbisservices.demo.kafka.utils.ServiceUtils;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class KafkaTopicCreate {
    private static final Logger log = LoggerFactory.getLogger(KafkaTopicCreate.class);

    public static void main(String[] args) throws Exception {
        log.info("Loading app properties ...");
        Properties properties = AppProperties.loadProperties();
        String topics = properties.getProperty(Constants.KAFKA_TOPICS_NAME);
        int partitions = ServiceUtils.convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_PARTITIONS));
        short replication = ServiceUtils.convertStringToShort(properties.getProperty(Constants.KAFKA_TOPIC_REPLICATION));
        log.info("Trying to create new topics: {}, partitions: {}, replication: {}", topics, partitions, replication);
        try (AdminClient adminClient = AdminClient.create(properties)) {
            List<NewTopic> newTopics = Arrays.stream(topics.split(","))
                    .filter(topic -> !KafkaUtils.topicExists(adminClient, topic))
                    .map(topic -> new NewTopic(topic, partitions, replication).configs(new HashMap<>()))
                    .collect(Collectors.toList());
            if (!newTopics.isEmpty()) {
                adminClient.createTopics(newTopics).all().get();
                log.info("Topics created: {}", newTopics);
            } else {
                log.warn("All topics already exists");
            }
        } catch (Exception e) {
            log.error("Exception when trying to create topics: {}", e.getMessage());
        }
    }
}
