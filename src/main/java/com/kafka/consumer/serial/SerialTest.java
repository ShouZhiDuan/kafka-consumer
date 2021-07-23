package com.kafka.consumer.serial;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.protobuf.ByteString;
import com.kafka.consumer.dto.DataDTO;
import com.kafka.consumer.proto_dto.DataDTOProto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 各种序列技术性能测试
 */
@Slf4j
public class SerialTest {

    private final static DataDTO dataDTO = new DataDTO("java", 6, "浙江省杭州市滨江区");

    /**
     * Java序列测试 233个字节
     */
    @Test
    public void javaSerialTest() throws IOException {
        ISerializer serializer = new JavaSerializer();
        //序列  233个字节
        byte[] serialize = serializer.serialize(dataDTO);
        log.info("JAVA序列后的对象大小：" + serialize.length + "字节");
        //反序列
        DataDTO deserialize = serializer.deserialize(serialize);
        log.info("JAVA反序列得到的对象数据：" + deserialize);
        log.info("JAVA序列测试完成");
    }

    /**
     * Xml序列测试 144个字节
     */
    @Test
    public void xmlSerialTest() throws IOException {
        ISerializer serializer = new XmlSerializer();
        //序列  144个字节
        byte[] serialize = serializer.serialize(dataDTO);
        log.info("XML序列后的对象大小：" + serialize.length + "字节");
        //反序列
        DataDTO deserialize = serializer.deserialize(serialize);
        log.info("XML反序列得到的对象数据：" + deserialize);
        log.info("XML序列测试完成");
    }

    /**
     * Hessian序列测试 97个字节
     */
    @Test
    public void hessianSerialTest() throws IOException {
        ISerializer serializer = new HessianSerializer();
        //序列  97个字节
        byte[] serialize = serializer.serialize(dataDTO);
        log.info("HESSIAN序列后的对象大小：" + serialize.length + "字节");
        //反序列
        DataDTO deserialize = serializer.deserialize(serialize);
        log.info("HESSIAN反序列得到的对象数据：" + deserialize);
        log.info("HESSIAN序列测试完成");
    }

    /**
     * FastJson序列测试 40字节
     * 参考：https://blog.csdn.net/u010246789/article/details/52539576/
     */
    @Test
    public void jsonSerialTest(){
        byte[] bytes = JSON.toJSONBytes(dataDTO, SerializerFeature.BeanToArray);
        System.out.printf(String.valueOf(bytes.length));
    }

    /**
     * ProtoBuf序列测试 37个字节
     */
    @Test
    public void protoBufSerialTest() {
        DataDTOProto.DataDTO dataDTO = DataDTOProto.DataDTO.newBuilder().setName("java").setAge(6).setAddr("浙江省杭州市滨江区").build();
        ByteString bs = dataDTO.toByteString();
        //序列 37个字节
        byte[] bytes = bs.toByteArray();
        log.info("PROTOC序列后的对象大小：" + bytes.length + "字节");
    }


}
