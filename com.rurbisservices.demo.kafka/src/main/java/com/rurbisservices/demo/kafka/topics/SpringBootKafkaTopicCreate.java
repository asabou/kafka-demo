package com.rurbisservices.demo.kafka.topics;

import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import com.rurbisservices.demo.kafka.utils.KafkaUtils;
import com.rurbisservices.demo.kafka.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SpringBootKafkaTopicCreate implements CommandLineRunner {

    @Autowired
    private AdminClient adminClient;

    private void createTopics() throws Exception {
        log.info("Trying to create topics ...");
        Properties properties = AppProperties.loadProperties();
        String topics = properties.getProperty(Constants.KAFKA_TOPICS_NAME);
        int partitions = ServiceUtils.convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_PARTITIONS));
        short replication = ServiceUtils.convertStringToShort(properties.getProperty(Constants.KAFKA_TOPIC_REPLICATION));
        List<NewTopic> newTopics = Arrays.stream(topics.split(","))
                .filter(topic -> !KafkaUtils.topicExists(adminClient, topic))
                .map(topic -> new NewTopic(topic, partitions, replication).configs(new HashMap<>()))
                .collect(Collectors.toList());
        if (!newTopics.isEmpty()) {
            adminClient.createTopics(newTopics).all().get();
            log.info("Topics created");
        } else {
            log.warn("All topics already exists");
        }
    }

    @Override
    public void run(String... args) throws Exception {
//       createTopics();
    }
}
