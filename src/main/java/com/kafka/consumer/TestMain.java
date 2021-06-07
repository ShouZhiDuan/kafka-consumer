package com.kafka.consumer;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        //消费者offset分区保存算法
        System.out.println(Math.abs("TestMsgConsumer-666666-1".hashCode())%50);
    }
}
