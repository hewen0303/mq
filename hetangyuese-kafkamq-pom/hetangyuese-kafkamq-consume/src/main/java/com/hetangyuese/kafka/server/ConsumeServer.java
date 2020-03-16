package com.hetangyuese.kafka.server;

import com.hetangyuese.kafka.constant.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: mq
 * @description: 消费监听
 * @author: hewen
 * @create: 2020-03-14 10:58
 **/
@Component
public class ConsumeServer {

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_A)
    public void receiveMessA(String message) {
        System.out.println("receive messageA = " + message);
    }

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_B)
    public void receiveMessB(String message) {
        System.out.println("receive messageB = " + message);
    }
}
