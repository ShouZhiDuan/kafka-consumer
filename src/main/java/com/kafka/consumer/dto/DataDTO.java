package com.kafka.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO implements Serializable {
    private String name;
    private Integer age;
    private String addr;
}
