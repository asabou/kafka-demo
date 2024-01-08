package com.rurbisservices.demo.kafka.producer;

import com.rurbisservices.demo.kafka.producer.abstracts.SpringBootKafkaProducerServiceInterface;
import com.rurbisservices.demo.kafka.schemas.CustomSchema1;
import com.rurbisservices.demo.kafka.schemas.CustomSchema2;
import com.rurbisservices.demo.kafka.schemas.CustomSchema3;
import com.rurbisservices.demo.kafka.schemas.CustomSchema4;
import com.rurbisservices.demo.kafka.utils.AppProperties;
import com.rurbisservices.demo.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;

import static com.rurbisservices.demo.kafka.utils.ServiceUtils.convertStringToInt;
import static com.rurbisservices.demo.kafka.utils.ServiceUtils.generateRandomString;

@Slf4j
@Component
public class SpringBootKafkaProducer implements CommandLineRunner {
    @Autowired
    @Qualifier("producer1")
    private SpringBootKafkaProducerServiceInterface<CustomSchema1> producer1;

    @Autowired
    @Qualifier("producer2")
    private SpringBootKafkaProducerServiceInterface<CustomSchema2> producer2;

    @Autowired
    @Qualifier("producer3")
    private SpringBootKafkaProducerServiceInterface<CustomSchema3> producer3;

    @Autowired
    @Qualifier("producer4")
    private SpringBootKafkaProducerServiceInterface<CustomSchema4> producer4;

    private void produceAsync() {
        log.info("Trying to produce messages async ...");
        Properties properties = AppProperties.loadProperties();
        int noMessages = convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_NUMBER_OF_MESSAGES));
        for (int i = 0; i < noMessages; i++) {
            producer1.produceMessageAsync(new CustomSchema1()
                    .withProperty1(generateRandomString()));
            producer2.produceMessageAsync(new CustomSchema2()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString()));
            producer3.produceMessageAsync(new CustomSchema3()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString()));
            producer4.produceMessageAsync(new CustomSchema4()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString())
                    .withProperty4(generateRandomString()));
        }
        log.info("Async messages sent");
    }

    private void produceSync() {
        log.info("Trying to produce messages sync ...");
        Properties properties = AppProperties.loadProperties();
        int noMessages = convertStringToInt(properties.getProperty(Constants.KAFKA_TOPIC_NUMBER_OF_MESSAGES));
        for (int i = 0; i < noMessages; i++) {
            producer1.produceMessageSync(new CustomSchema1()
                    .withProperty1(generateRandomString()));
            producer2.produceMessageSync(new CustomSchema2()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString()));
            producer3.produceMessageSync(new CustomSchema3()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString()));
            producer4.produceMessageSync(new CustomSchema4()
                    .withProperty1(generateRandomString())
                    .withProperty2(generateRandomString())
                    .withProperty3(generateRandomString())
                    .withProperty4(generateRandomString()));
        }
        log.info("Sync messages produced");
    }
    @Override
    public void run(String... args) throws Exception {
        //TODO: check why Spring Kafka Producer produce messages that are not distributed equally in partitions (eg. some partitions have 0 messages, some others have hundreds)
        produceAsync();
//        produceSync();
    }
}
