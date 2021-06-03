package com.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Slf4j
@Component
public class KafkaAckModeConsumer {

    private final static String TOPIC = "test-topic-89";

    /**
     * MANUAL
     * 当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后, 手动调用Acknowledgment.acknowledge()后提交
     */
    @KafkaListener(containerFactory = "manualListenerContainerFactory", topics = TOPIC, groupId = "MANUAL-1")
    public void onMessageManual(List<Object> message, Acknowledgment ack){
        log.info("manualListenerContainerFactory 处理数据量：{}",message.size());
        message.forEach(item -> log.info("manualListenerContainerFactory 处理数据内容：{}",item));
        ack.acknowledge();//直接提交offset
    }


    /**
     * MANUAL_IMMEDIATE 手动调用Acknowledgment.acknowledge()后立即提交
     * @param message
     */
    @KafkaListener(containerFactory = "manualImmediateListenerContainerFactory", topics = TOPIC, groupId = "MANUAL_IMMEDIATE")
    public void onMessageManualImmediate(List<Object> message, Acknowledgment ack){
        log.info("manualImmediateListenerContainerFactory 处理数据量：{}",message.size());
        message.forEach(item -> log.info("manualImmediateListenerContainerFactory 处理数据内容：{}",item));
        ack.acknowledge();//直接提交offset
    }

    /**
     * TIME     当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后，距离上次提交时间大于TIME时提交
     * @param message
     */
    @KafkaListener(containerFactory = "timeListenerContainerFactory" , topics = TOPIC, groupId = "TIME")
    public void onMessageTime(List<Object> message){
        log.info("timeListenerContainerFactory 处理数据量：{}",message.size());
        message.forEach(item -> log.info("timeListenerContainerFactory 处理数据内容：{}",item));
    }


    /**
     * COUNT    当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后，被处理record数量大于等于COUNT时提交
     */
    @KafkaListener(containerFactory = "countListenerContainerFactory", topics = TOPIC, groupId = "COUNT")
    public void onMessageCount(List<Object> message){
        log.info("countListenerContainerFactory 处理数据量：{}",message.size());
        message.forEach(item -> log.info("countListenerContainerFactory 处理数据内容：{}",item));
    }



}
