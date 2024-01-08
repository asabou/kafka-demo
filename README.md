# Kafka, Zookeeper and Kafdrop
### How to start?
1. execute run.sh -> this will create a zookeeper, kafka and kafdrop containers
2. Kafka core:
    1. Run class KafkaTopicCreate to create the kafka topics that are defined in kafka-app.properties
    2. Run class KafkaProducer to create the kafka messages
    3. Run class KafkaConsumer to consume the kafka messages
3. Kafka Spring:
    1. Take a look in the following classes:
        1. SpringBootKafkaTopicCreate: it is responsible for creating Kafka topics from Spring Boot
    	2. SpringBootKafkaProducer: it is responsible to produce kafka messages
        3. SpringBootSchemaXXXXConsumerImpl: it is responsible to consume the messages
    2. Config classes:
        1. SpringBootKafkaProducerConfig: it is responsible to create the following beans: KafkaAdmin, Adminclient, ProducerFactory, KafkaTemplate
        2. SpringBootKafkaConsumerConfig: it is responsible to create listeners beans for the consumers
    3. Run class Main
4. GUI for the kafka messages: localhost:9000