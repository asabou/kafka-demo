package com.rurbisservices.demo.kafka.utils;

import org.apache.kafka.clients.admin.AdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaUtils {
    private static final Logger log = LoggerFactory.getLogger(KafkaUtils.class);
    public static boolean topicExists(AdminClient adminClient, String topic) {
        try {
            return adminClient.listTopics().names().get().contains(topic);
        } catch (Exception e) {
            log.error("Exception when checking topic {}", topic);
            log.error("Exception: {}", e.getMessage());
            return false;
        }
    }
}
