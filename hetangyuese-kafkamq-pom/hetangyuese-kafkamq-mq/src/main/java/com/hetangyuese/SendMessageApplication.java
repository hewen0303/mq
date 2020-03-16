package com.hetangyuese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @program: mq
 * @description: 发送消息类
 * @author: hewen
 * @create: 2020-03-14 10:43
 **/
@SpringBootApplication
public class SendMessageApplication extends SpringBootServletInitializer{

    /**
     *  SpringBootServletInitializer为了打包成war
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.listeners();
        return builder.sources(SendMessageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SendMessageApplication.class, args);
    }
}
