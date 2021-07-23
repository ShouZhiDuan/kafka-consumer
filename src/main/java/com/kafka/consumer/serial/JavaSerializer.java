package com.kafka.consumer.serial;

import java.io.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description: JAVA序列、反序列方式
 */
public class JavaSerializer implements ISerializer {

    /**
     * 序列化
     */
    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        //写到文件中
        //ObjectOutputStream oosFile = new ObjectOutputStream(new FileOutputStream("E:/test/serial"));
        oos.writeObject(obj);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    /**
     * 反序列化
     */
    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayOutputStream);
            //从文件中读取
            //ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("E:/test/serial")));
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
