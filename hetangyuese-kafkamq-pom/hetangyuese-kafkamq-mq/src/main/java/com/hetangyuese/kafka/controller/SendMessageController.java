package com.hetangyuese.kafka.controller;

import com.hetangyuese.kafka.util.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mq
 * @description: 发送消息类
 * @author: hewen
 * @create: 2020-03-14 10:43
 **/
@RestController
@RequestMapping("/kafka")
public class SendMessageController {

    @Autowired
    private SendMessageUtil sendMessageUtil;

    @RequestMapping("/send")
    public String send(String message) {
        sendMessageUtil.send(message);
        return "success";
    }
}
