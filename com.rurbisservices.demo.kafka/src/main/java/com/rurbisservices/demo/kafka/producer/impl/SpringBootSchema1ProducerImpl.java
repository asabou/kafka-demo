package com.rurbisservices.demo.kafka.producer.impl;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerService;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("producer1")
@Service
public class SpringBootSchema1ProducerImpl extends SpringBootKafkaProducerService<CustomSchema1> {
    public SpringBootSchema1ProducerImpl() {
        super(AppProperties.loadProperties().getProperty(Constants.KAFKA_TOPICS_NAME).split(",")[0],
                CustomSchema1.class);
    }
}
