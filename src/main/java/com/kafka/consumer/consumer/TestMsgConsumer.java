package com.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 * 更多@KafkaListener操作清参考： https://blog.csdn.net/cowbin2012/article/details/85407495
 */
@Slf4j
@Component
public class TestMsgConsumer {

    private final static String TOPIC = "test-topic-88";

    /**
     * 不指定分区消费(单个串行消费)
     */
    @KafkaListener(topics = {TOPIC},groupId = "TestMsgConsumer-666666-6")
    public void test(ConsumerRecord record){
        Optional<?> msg = Optional.ofNullable(record.value());
        if(msg.isPresent()){
            System.err.println(msg.get());
        }
    }

    /**
     * 指定分区消费(单个串行消费)
     */
//    @KafkaListener(topicPartitions = { @TopicPartition(topic = TOPIC, partitions = { "1" }) },groupId = "2")
//    public void test1(ConsumerRecord record){
//        Optional<?> msg = Optional.ofNullable(record.value());
//        if(msg.isPresent()){
//            System.err.println(msg.get());
//        }
//    }

    /**
     * 批量消费
     */
//    @KafkaListener(topics = {TOPIC}, containerFactory = "batchFactory", groupId = "batch-7")
//    public void test2(List<ConsumerRecord<?, ?>> record) {
//        log.info("接收到消息数量：{}", record.size());
//    }


    /**
     * 获取kafka消息头信息
     * ======>>>>>>
     * data : 测试消息test-topic-88-msg-3
     * key :    
     * partitionId : 0
     * topic : test-topic-89
     * timestamp : 1622604215412
     * <<<<<<======
     */
//    @KafkaListener(id = "group3", topics = TOPIC)
//    public void annoListener(@Payload String data,
//                             @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
//                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String ts) {
//                    log.info(" receive : \n"+
//                            "data : "+data+"\n"+
//                            "key : "+key+"\n"+
//                            "partitionId : "+partition+"\n"+
//                            "topic : "+topic+"\n"+
//                            "timestamp : "+ts+"\n"
//        );
//    }

    /**
     * 手动提交
     * topics订阅的消息主题可以多个{"a","b"}
     * group-DszConsumer3-1消费组ID
     * ackContainerFactory自定消费策略
     */
//    @KafkaListener(id = "group-DszConsumer3-1", topics = TOPIC, containerFactory = "ackContainerFactory")
//    public void ackListener(ConsumerRecord record, Acknowledgment ack) {
//        String topic = record.topic();
//        long offset = record.offset();
//        int partition = record.partition();
//        log.info("当前消息topic={},offset={},partition={}",topic,offset,partition);
//        //手动提交
//        ack.acknowledge();
//    }


}



