package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mq
 * @description:
 * @author: hewen
 * @create: 2020-03-09 15:41
 **/
@SpringBootApplication
public class RabbitMqConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerServer.class, args);
    }
}
