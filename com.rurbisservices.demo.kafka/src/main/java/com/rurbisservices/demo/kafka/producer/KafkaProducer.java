package com.rurbisservices.demo.kafka.producer;

import com.rurbisservices.demo.kafka.producer.impl.Schema1ProducerImpl;
import com.rurbisservices.demo.kafka.producer.impl.Schema2ProducerImpl;
import com.rurbisservices.demo.kafka.producer.impl.Schema3ProducerImpl;
import com.rurbisservices.demo.kafka.producer.impl.Schema4ProducerImpl;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static com.rurbisservices.demo.kafka.utils.ServiceUtils.convertStringToInt;
import static com.rurbisservices.demo.kafka.utils.ServiceUtils.generateRandomString;

public class KafkaProducer {
    public static void main(String[] args) throws Exception {
        Properties properties = AppProperties.loadProperties();
        List<String> topics = Arrays.asList(properties.getProperty(Constants.KAFKA_TOPICS_NAME).split(","));
        Schema1ProducerImpl schema1Producer = new Schema1ProducerImpl(topics.get(0), CustomSchema1.class);
        Schema2ProducerImpl schema2Producer = new Schema2ProducerImpl(topics.get(1), CustomSchema2.class);
        Schema3ProducerImpl schema3Producer = new Schema3ProducerImpl(topics.get(2), CustomSchema3.class);
        Schema4ProducerImpl schema4Producer = new Schema4ProducerImpl(topics.get(3), CustomSchema4.class);

        int noMessages = convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_NUMBER_OF_MESSAGES));
        for (int i = 0; i < noMessages; i++) {
            schema1Producer.produce(new CustomSchema1()
                    .withProperty1(generateRandomString()));

            schema2Producer.produce(new CustomSchema2()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString()));

            schema3Producer.produce(new CustomSchema3()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString()));

            schema4Producer.produce(new CustomSchema4()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString())
                    .withProperty4(generateRandomString()));

        }
    }
}
