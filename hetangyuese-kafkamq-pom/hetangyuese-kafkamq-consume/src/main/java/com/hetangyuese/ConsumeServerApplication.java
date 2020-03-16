package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @program: mq
 * @description: 消费监听
 * @author: hewen
 * @create: 2020-03-14 10:58
 **/
@SpringBootApplication
public class ConsumeServerApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.listeners();
        return builder.sources(ConsumeServerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumeServerApplication.class, args);
    }
}
