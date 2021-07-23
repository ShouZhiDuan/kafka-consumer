package com.kafka.consumer.consumer;

import com.kafka.producer.DTO.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 消息序列化以及消息转换器研究
 */
@Slf4j
//@Component
public class DeserialConsumer {

    /**
     * JSON串主题
     */
    private final static String TOPIC = "test-topic-89";

    private final static String TOPIC1 = "test-topic-fix";

    /**
     * kafka默认消费模式
     * (串行单个拉取消费模式)
     *
     */
    @KafkaListener(topics = {TOPIC1},groupId = "_serial_consumer_1")
//    public void test1(DataDTO producerDto, ConsumerRecord record){         //单调也能接收
      public void test1(DataDTO producerDto, ConsumerRecord record){         //单调也能接收
       // String s = record.key().toString();
        //DataDTO key = producerDto.get("key");

//    //public void test1(List<DataDTO> data){     //多条也能也能接收
//    //public void test1(@Payload List<String> data){
//    public void test1(String data,String data1, ConsumerRecord record){
        //Object value = record.value();
        System.out.println("======Kafka默认消费模式======");
        //单个
        //System.out.println("数据内容：" + data);
        //多个
//        System.out.println("数据内容：" + data);
//        System.out.println("数据数量：" + data.size());
//        for (int i = 0; i < data.size(); i++){
//           System.out.println("Value：" + i + " = " + data.get(i));
//        }
    }


    /**
     * kafka自定义消费模式
     * (批量拉取批量消费)
     * spring.kafka.consumer.value-deserializer=com.kafka.consumer.deserializer.DataDTODeserializer
     */
//    @KafkaListener(topics = "test-topic-fix",groupId = "_serial_consumer_2", containerFactory = "batchFactory")
//    public void test2(List<DataDTO> data,List<ConsumerRecord> records){
//        System.out.println("======Kafka批量消费模式======");
//        System.out.println("数据内容：" + data);
//        System.out.println("数据数量：" + data.size());
//        for (int i = 0; i < data.size(); i++){
//            System.out.println("Value：" + i + "  " + data.get(i));
//        }
//    }








}
