package com.hetangyuese.acmq.controller;

import com.hetangyuese.mq.config.ActivitiProduce;
import com.hetangyuese.mq.config.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @program: mq
 * @description: ceshi
 * @author: hewen
 * @create: 2020-03-05 18:24
 **/
@RestController
@RequestMapping("/publish")
public class MqPublishController {

    @Autowired
    private ActivitiProduce activitiProduce;

    @Autowired
    private Queue syncNotifyQueue;

    @Autowired
    private Topic topic;

    @RequestMapping("/test")
    public void publish(String task) {
        activitiProduce.send(syncNotifyQueue, task);
//        for (int i=0; i<2; i++) {
//            activitiProduce.send(syncNotifyQueue, task);
//        }
    }

    @RequestMapping("/topic")
    public void testTopic(String topicStr) {
        activitiProduce.sendTopic(topic, topicStr);
    }
}
