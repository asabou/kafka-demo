package com.rurbisservices.demo.kafka.consumer;

import com.rurbisservices.demo.kafka.consumer.impl.Schema1ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.Schema2ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.Schema3ConsumerImpl;
import com.rurbisservices.demo.kafka.consumer.impl.Schema4ConsumerImpl;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class KafkaConsumer {
    public static void main(String[] args) throws Exception {
        Properties properties = AppProperties.loadProperties();
        List<String> topics = Arrays.asList(properties.getProperty(Constants.KAFKA_TOPICS_NAME).split(","));

        Schema1ConsumerImpl schema1Consumer = new Schema1ConsumerImpl(topics.get(0), CustomSchema1.class);
        schema1Consumer.consume();

        Schema2ConsumerImpl schema2Consumer = new Schema2ConsumerImpl(topics.get(1), CustomSchema2.class);
        schema2Consumer.consume();

        Schema3ConsumerImpl schema3Consumer = new Schema3ConsumerImpl(topics.get(2), CustomSchema3.class);
        schema3Consumer.consume();

        Schema4ConsumerImpl schema4Consumer = new Schema4ConsumerImpl(topics.get(3), CustomSchema4.class);
        schema4Consumer.consume();
    }
}
