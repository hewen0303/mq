package com.hetangyuese.kafka.util;

import com.hetangyuese.kafka.constant.KafkaConstants;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @program: mq
 * @description: 发送消息类
 * @author: hewen
 * @create: 2020-03-14 10:43
 **/
@Component
public class SendMessageUtil {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(String message ) {
        ListenableFuture<SendResult<String, Object>> future =  kafkaTemplate.send(KafkaConstants.TOPIC, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("消息发送失败了");
            }

            @Override
            public void onSuccess(@Nullable SendResult<String, Object> stringObjectSendResult) {
                System.out.println("消息发送成功了");
            }
        });
    }
}
