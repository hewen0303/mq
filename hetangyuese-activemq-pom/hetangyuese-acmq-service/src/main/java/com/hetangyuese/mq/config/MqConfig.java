package com.hetangyuese.mq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class MqConfig {

	public final static String MQ_NOTIFY_TOPIC_SYNC_TAG = "mq.notify.topic.sync.tag";
	public final static String MQ_NOTIFY_TOPIC_VOUCHER_NOTIFY_TAG = "mq.notify.topic.voucher.notify.tag";
	public final static String MQ_NOTIFY_TOPIC_VOUCHER_SEND_SMS_TAG = "mqnotify.topic.voucher.send.sms.tag";
	public final static String MQ_NOTIFY_TOPIC_HOTEL_SEND_SMS_TAG = "mqnotify.topic.hotel.send.sms.tag";

	@Bean
	public Queue syncNotifyQueue() {
		return new ActiveMQQueue(MQ_NOTIFY_TOPIC_SYNC_TAG);
	}

	@Bean
	public Queue voucherSmsNotifyQueue() {
		return new ActiveMQQueue(MQ_NOTIFY_TOPIC_VOUCHER_SEND_SMS_TAG);
	}
	
	@Bean
	public Queue hotelSmsNotifyQueue() {
		return new ActiveMQQueue(MQ_NOTIFY_TOPIC_HOTEL_SEND_SMS_TAG);
	}

	@Bean
	public Queue voucherNotifyQueue() {
		return new ActiveMQQueue(MQ_NOTIFY_TOPIC_VOUCHER_NOTIFY_TAG);
	}

	@Bean(name = "topic")
	public Topic testTopic() {
		return new ActiveMQTopic("topic");
	}

}
