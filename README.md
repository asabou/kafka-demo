# Kafka, Zookeeper and Kafdrop
### How to start?
1. execute run.sh -> this will create a zookeeper, kafka and kafdrop containers
2. Java project:
    1. Run class KafkaTopicCreate to create the kafka topics that are defined in kafka-app.properties
    2. Run class KafkaProducer to create the kafka messages
    3. Run class KafkaConsumer to consume the kafka messages
3. GUI for the kafka messages: localhost:9000