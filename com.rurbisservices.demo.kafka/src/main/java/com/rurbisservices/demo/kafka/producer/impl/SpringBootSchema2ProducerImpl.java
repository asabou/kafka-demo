package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("producer2")
@Service
public class SpringBootSchema2ProducerImpl extends SpringBootKafkaProducerService<CustomSchema2> {
    public SpringBootSchema2ProducerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[1],
                CustomSchema2.class);
    }
}
