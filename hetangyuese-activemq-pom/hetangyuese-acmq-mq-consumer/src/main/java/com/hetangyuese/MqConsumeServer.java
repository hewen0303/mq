package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mq
 * @description:
 * @author: hewen
 * @create: 2020-03-05 18:57
 **/
@SpringBootApplication
public class MqConsumeServer {

    public static void main(String[] args) {
        SpringApplication.run(MqConsumeServer.class, args);
    }
}
