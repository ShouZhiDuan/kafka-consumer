package com.kafka.consumer.serial;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: ShouZhi@Duan
 * @Description: XML序列、反序列方式
 */
@Slf4j
public class XmlSerializer implements ISerializer {

    XStream stream;

    public XmlSerializer() {
        stream = new XStream(new DomDriver());
    }

    @Override
    public <T> byte[] serialize(T obj) {
        byte[] bytes = this.stream.toXML(obj).getBytes();
        return bytes;
    }

    @Override
    public <T> T deserialize(byte[] data) {
        return (T) this.stream.fromXML(new String(data));
    }
}
