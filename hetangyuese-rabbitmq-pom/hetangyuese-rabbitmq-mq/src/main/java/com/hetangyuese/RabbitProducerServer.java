package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mq
 * @description: 测试
 * @author: hewen
 * @create: 2020-03-09 15:38
 **/
@SpringBootApplication
public class RabbitProducerServer {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerServer.class, args);
    }
}
