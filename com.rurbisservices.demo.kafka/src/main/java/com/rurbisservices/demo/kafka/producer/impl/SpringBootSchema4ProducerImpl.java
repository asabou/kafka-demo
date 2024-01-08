package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("producer4")
@Service
public class SpringBootSchema4ProducerImpl extends SpringBootKafkaProducerService<CustomSchema4> {
    public SpringBootSchema4ProducerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[3],
                CustomSchema4.class);
    }
}
