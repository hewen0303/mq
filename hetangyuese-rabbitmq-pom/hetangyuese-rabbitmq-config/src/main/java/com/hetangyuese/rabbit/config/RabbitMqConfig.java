package com.hetangyuese.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: mq
 * @description: rabbit配置
 * @author: hewen
 * @create: 2020-03-09 15:30
 **/
@Configuration
public class RabbitMqConfig {

    public static final String HELLO_QUEUE = "hello";

    public static final String DIRECT_QUEUE = "dirHello";

    public static final String MESSAGE_QUEUE = "messagequeue";

    public static final String MESSAGE_QUEUE_A = "messagequeueA";

    public static final String MESSAGE_QUEUE_B = "messagequeueB";

    public static final String MESSAGE_EXCHANGE = "message.direct.exchange.hetangyuese";

    public static final String FANOUT_EXCHANGE = "message.fanout.exchange.hetangyuese";

    // 消息路由键
    public static final String MESSAGE_ROUTE_KEY = "message.route.hetangyuese";

    @Bean
    public Queue helloQueue() {
        return new Queue(HELLO_QUEUE);
    }

    /**
     * 消息队列声明
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return QueueBuilder.durable(DIRECT_QUEUE).build();
    }

    @Bean
    public Queue messageQueueA() {
        return QueueBuilder.durable(MESSAGE_QUEUE_A).build();
    }

    @Bean
    public Queue messageQueueB() {
        return QueueBuilder.durable(MESSAGE_QUEUE_B).build();
    }

//    /**
//     * 配置交换机
//     *
//     * @return
//     */
//    @Bean
//    public DirectExchange messageDirectExchange() {
//        return (DirectExchange) ExchangeBuilder.directExchange(MESSAGE_EXCHANGE)
//                .durable(true)
//                .build();
//    }

    /**
     * 建立fanout交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE).durable(false).build();
    }

    @Bean
    public Binding messageQueueABind(Queue messageQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageQueueA)
                .to(fanoutExchange);
    }

    @Bean
    public Binding messageQueueBBinding(Queue messageQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageQueueB)
                .to(fanoutExchange);
    }


//    /**
//     * 消息绑定
//     *
//     * @return
//     */
//    @Bean
//    public Binding messageBinding() {
//        return BindingBuilder.bind(messageQueue())
//                .to(messageDirectExchange())
//                .with(MESSAGE_ROUTE_KEY);
//    }
//
//    /**
//     * 消息绑定
//     *
//     * @return
//     */
//    @Bean
//    public Binding messageBinding1() {
//        return BindingBuilder.bind(helloQueue())
//                .to(messageDirectExchange())
//                .with(MESSAGE_ROUTE_KEY);
//    }

    public static Integer a = 11125;

    private void test() throws InterruptedException {
//        synchronized(this) {
        synchronized (a.toString().intern()) {
            a++; //
            System.out.println(Thread.currentThread().getName() + " coming " + a);
        }
    }

    class T1 implements Runnable {
        @Override
        public void run() {
            try {
//                synchronized(this) {
                test();
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 rabbitMqConfig = new RabbitMqConfig().new T1();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 1; i < 50; i++) {
            executorService.submit(rabbitMqConfig);
        }
    }

}
