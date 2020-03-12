package com.hetangyuese.rabbitmq.consume;

import com.hetangyuese.rabbit.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: mq
 * @description:
 * @author: hewen
 * @create: 2020-03-09 15:41
 **/
@Component
public class RabbitMqConsumer {

    /**
     *  queue队列模式，存在多个消费者和acmq一样轮流消费，每个消息只会消费一次
     * @param message
     */
    @RabbitListener(queues = RabbitMqConfig.DIRECT_QUEUE)
    public void listen(String message) {
        System.out.println("message= " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.HELLO_QUEUE)
    public void listen1(String message) {
        System.out.println("message1= " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.MESSAGE_QUEUE_A)
    public void listenerFan(String message) {
        System.out.println("messageA= " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.MESSAGE_QUEUE_B)
    public void listenerFanB(String message) {
        System.out.println("messageB= " + message);
    }
}
