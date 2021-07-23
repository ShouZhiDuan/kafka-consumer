package com.kafka.consumer.serial;

import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 序列化工具
 */
public interface ISerializer {

    /**
     * 序列化
     */
    <T> byte[] serialize(T obj) throws IOException;

    /**
     * 反序列化
     */
    <T> T deserialize(byte[] data);
}
