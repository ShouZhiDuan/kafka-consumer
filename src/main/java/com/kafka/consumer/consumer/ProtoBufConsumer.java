package com.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Description: protobuf序列化
 */
@Slf4j
@Component
public class ProtoBufConsumer {

    @KafkaListener
    public void consumerProtobuf(){

    }

}
