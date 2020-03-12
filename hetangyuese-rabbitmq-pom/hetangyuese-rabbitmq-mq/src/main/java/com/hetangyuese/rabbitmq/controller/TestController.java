package com.hetangyuese.rabbitmq.controller;

import com.hetangyuese.rabbit.config.RabbitMqConfig;
import com.hetangyuese.rabbit.config.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mq
 * @description: 测试
 * @author: hewen
 * @create: 2020-03-09 15:38
 **/
@RestController
@RequestMapping("/rabbit")
public class TestController {

    @Autowired
    RabbitProducer rabbitProducer;

    @RequestMapping("/send")
    public String send(String message) {
//        rabbitProducer.send(RabbitMqConfig.DIRECT_QUEUE, message);
//        rabbitProducer.send(RabbitMqConfig.MESSAGE_EXCHANGE, RabbitMqConfig.MESSAGE_ROUTE_KEY, message);
        rabbitProducer.sendFanout(RabbitMqConfig.FANOUT_EXCHANGE, message);
        return "success";
    }
}
