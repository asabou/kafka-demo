package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("producer3")
@Service
public class SpringBootSchema3ProducerImpl extends SpringBootKafkaProducerService<CustomSchema3> {
    public SpringBootSchema3ProducerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[2],
                CustomSchema3.class);
    }
}
