package com.rurbisservices.demo.kafka.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class KafkaUtils {
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
