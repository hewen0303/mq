package com.hetangyuese.mq.config;

import org.apache.activemq.ScheduledMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class ActivitiProduce {

	private final Logger _log = LoggerFactory.getLogger(ActivitiProduce.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 *  消息队列 如果存在多个消费者则一人消费一次
	 * @param queue
	 * @param msg
	 */
	public void send(Queue queue, String msg) {
		_log.info("发送MQ消息:msg={}", msg);
		this.jmsTemplate.convertAndSend(queue, msg);
	}

	/**
	 *  发布订阅模式
	 * @param topic
	 * @param msg
	 */
	public void sendTopic(Topic topic, String msg) {
		jmsTemplate.convertAndSend(topic, msg);
	}

	/**
	 * 发送延迟消息
	 * 
	 * @param msg
	 * @param delay
	 */
	public void send(Queue queue, final String msg, final long delay) {
		_log.info("发送MQ延时消息:msg={},delay={}", msg, delay);
		jmsTemplate.send(queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage tm = session.createTextMessage(msg);
				tm.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
				tm.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1 * 1000);
				tm.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
				return tm;
			}
		});
	}
}
