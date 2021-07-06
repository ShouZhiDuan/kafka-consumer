package com.kafka.consumer.maintest;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@AllArgsConstructor
public class MySerial implements Serializable {
    private static final long serialVersionUID = 2L;
    private String age;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
