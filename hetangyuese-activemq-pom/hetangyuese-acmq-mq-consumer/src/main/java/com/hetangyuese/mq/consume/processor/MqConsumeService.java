package com.hetangyuese.mq.consume.processor;

import com.hetangyuese.mq.config.MqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @program: mq
 * @description: 发布测试
 * @author: hewen
 * @create: 2020-03-05 18:30
 **/
@Service
public class MqConsumeService {

    @JmsListener(destination = MqConfig.MQ_NOTIFY_TOPIC_SYNC_TAG)
    public void consume(String msg) {
        System.out.println("收到消息：" + msg);
    }

    @JmsListener(destination = MqConfig.MQ_NOTIFY_TOPIC_SYNC_TAG)
    public void consume1(String msg) {
        System.out.println("收到消息1：" + msg);
    }

    @JmsListener(destination = "topic")
    public void consumeTopic(String msg) {
        System.out.println("收到消息：" + msg);
    }

    @JmsListener(destination = "topic")
    public void consumeTopic1(String msg) {
        System.out.println("收到消息1：" + msg);
    }

}
