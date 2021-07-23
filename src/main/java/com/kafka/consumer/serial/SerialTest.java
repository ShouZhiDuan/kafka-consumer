package com.kafka.consumer.serial;

import com.kafka.consumer.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Slf4j
public class SerialTest {

    private final static DataDTO dataDTO = new DataDTO("java",6,"浙江省杭州市滨江区");

    /**
     * Java序列化测试
     */
    @Test
    public void javaSerialTest() throws IOException {
        ISerializer serializer = new JavaSerializer();
        //序列化  233个字节
        byte[] serialize = serializer.serialize(dataDTO);
        log.info("JAVA序列后的对象大小：" + serialize.length + "字节");
        //反序列化
        DataDTO deserialize = serializer.deserialize(serialize);
        log.info("JAVA反序列得到的对象数据：" + deserialize);
        log.info("完成java序列化测试");
    }

    /**
     * Xml序列化测试
     */
    @Test
    public void xmlSerialTest() throws IOException {
        ISerializer serializer = new XmlSerializer();
        //序列化  144个字节
        byte[] serialize = serializer.serialize(dataDTO);
        log.info("XML序列后的对象大小：" + serialize.length + "字节");
        //反序列化
        DataDTO deserialize = serializer.deserialize(serialize);
        log.info("XML反序列得到的对象数据：" + deserialize);
        log.info("完成java序列化测试");
    }

    /**
     * Hessian序列化测试
     */
    @Test
    public void hessianSerialTest(){

    }

    /**
     * ProtoBuf序列化测试
     */
    @Test
    public void protoBufSerialTest(){

    }


}