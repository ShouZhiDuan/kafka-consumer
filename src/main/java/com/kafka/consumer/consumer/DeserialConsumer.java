package com.kafka.consumer.consumer;

import com.kafka.consumer.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 消息序列化以及消息转换器研究
 */
@Slf4j
@Component
public class DeserialConsumer {

    /**
     * JSON串主题
     */
    private final static String TOPIC = "test-topic-89";

    /**
     * kafka默认消费模式
     * (串行单个拉取消费模式)
     */
    @KafkaListener(topics = {TOPIC},groupId = "_serial_consumer_1")
    public void test1(DataDTO data){         //单调也能接收
    //public void test1(List<DataDTO> data){     //多条也能也能接收
        System.out.println("======Kafka默认消费模式======");
        System.out.println("数据内容：" + data);
    }


    /**
     * kafka自定义消费模式
     * (批量拉取批量消费)
     */
//    @KafkaListener(topics = {TOPIC},groupId = "_serial_consumer_2", containerFactory = "batchFactory")
//    public void test2(List<DataDTO> data){
//        System.out.println("======Kafka批量消费模式======");
//        System.out.println("数据内容：" + data);
//        System.out.println("数据数量：" + data.size());
//        for (int i = 0; i < data.size(); i++){
//            System.out.println("Value：" + i + "  " + data.get(i));
//        }
//    }






}
