package com.kafka.consumer.serial;

import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Description: XML序列、反序列方式
 */
public class XmlSerializer implements ISerializer{
    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data) {
        return null;
    }
}
