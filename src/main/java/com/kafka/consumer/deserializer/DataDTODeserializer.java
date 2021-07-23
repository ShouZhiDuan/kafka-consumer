package com.kafka.consumer.deserializer;

import com.alibaba.fastjson.JSON;
import com.kafka.producer.DTO.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Slf4j
public class DataDTODeserializer implements Deserializer {

    private String encoding = "UTF8";

    @Override
    public void configure(Map configs, boolean isKey) {
        String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null) {
            encodingValue = configs.get("deserializer.encoding");
        }
        if (encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }
    }

    @Override
    public DataDTO deserialize(String s, byte[] bytes) {
        DataDTO dataDTO = JSON.parseObject(bytes, DataDTO.class);
        log.info("自定义反序列化，ConsumerRecorder#value类型为：" + dataDTO.getClass().getName());
        return dataDTO;
    }
}
