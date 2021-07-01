package com.kafka.consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        //消费者offset分区保存算法
        //System.out.println(Math.abs("TestMsgConsumer-666666-6".hashCode())%50);

//        数据内容：[{"addr":"地址", "age":16, "name":"testName"}]
//        数据数量：3
//        Value：0  {"addr":"地址"
//        Value：1  "age":16
//        Value：2  "name":"testName"}
        List<String> list = new ArrayList<>();
        list.add("{\"addr\":\"地址\"");
        list.add("\"age\":16");
        list.add("\"name\":\"testName\"}");
        System.out.println(list);
    }
}
