#Kafka消费端

##1、消费者offset分区算法to see com.kafka.consumer.TestMain
Math.abs("consumer-group-id".hashCode())%50

##2、消费模式
to see com.kafka.consumer.consumer.KafkaAckModeConsumer


