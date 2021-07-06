package com.kafka.consumer.maintest;

import java.io.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class MySerialTestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写
        //writeObject(new MySerial("16", "shouzhi@duan"), "E:/dsz-test-work/Myserial.txt");
        //读
        readObject("E:/dsz-test-work/Myserial.txt");

    }

    /**
     * 写
     */
    public static void writeObject(Object dataSource, String target) throws IOException {
        System.out.println("序列化：" + dataSource);
        FileOutputStream outputStream = new FileOutputStream(target);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(dataSource);
    }

    /**
     * 读
     */
    public static void readObject(String target) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(target);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        MySerial object = (MySerial) objectInputStream.readObject();
        System.out.println("反序列化：" + object);
    }


}
