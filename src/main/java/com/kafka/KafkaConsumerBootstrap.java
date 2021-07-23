package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerBootstrap.class, args);
    }

}
