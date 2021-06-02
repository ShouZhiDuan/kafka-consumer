package com.kafka.consumer.task;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListConsumerGroupOffsetsResult;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 * 参考：https://zhuanlan.zhihu.com/p/112745985
 */
@Component
//@EnableScheduling
public class KafkaTask {

    @Scheduled(fixedRate = 1000)
    public void schedule(){
        System.out.println("======");
        Map<TopicPartition, OffsetAndMetadata> offset1 = lagOf("batch-7", "192.168.10.33:9092,192.168.10.34:9092");
        for(Map.Entry<TopicPartition, OffsetAndMetadata> entry : offset1.entrySet()){
            System.out.println(new Date().toString() + "consumer batch-7:topic-" + entry.getKey().topic() + "partition-" + entry.getKey().partition() + " offset" + entry.getValue().offset());
        }
    }

    public static Map<TopicPartition, OffsetAndMetadata> lagOf(String groupID, String bootstrapServers){
        Properties props = new Properties();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        try (AdminClient client = AdminClient.create(props)){
            ListConsumerGroupOffsetsResult result = client.listConsumerGroupOffsets(groupID);
            Map<TopicPartition,OffsetAndMetadata> consumeOffsets = result.partitionsToOffsetAndMetadata().get(10, TimeUnit.SECONDS);
            return consumeOffsets;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }



}
