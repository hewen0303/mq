package com.hetangyuese.rabbit.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mq
 * @description: 消息发布者
 * @author: hewen
 * @create: 2020-03-09 15:33
 **/
@Service
public class RabbitProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void send(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendFanout(String fanoutExchange, String message) {
        rabbitTemplate.convertAndSend(fanoutExchange, "", message);
    }


    public void send(String exchange, String routeKey, String msg) {
        rabbitTemplate.convertAndSend(exchange, routeKey, msg);
    }

}
