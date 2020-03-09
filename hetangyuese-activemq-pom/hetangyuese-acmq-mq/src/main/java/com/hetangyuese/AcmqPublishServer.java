package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @program: mq
 * @description: ceshi
 * @author: hewen
 * @create: 2020-03-05 18:24
 **/
@SpringBootApplication
@EnableJms
public class AcmqPublishServer {

    public static void main(String[] args) {
        SpringApplication.run(AcmqPublishServer.class, args);
    }
}
