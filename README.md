# rabbitmq
``常用的模式： queue队列模式； directExchange路由模式、fanoutExchange模式``
### rabbitmq使用方法
+ 配置mq队列及模式类<br/>
    <br/>
    ````
    // 配置队列
    @Bean
    public Queue helloQueue() {
        return new Queue(HELLO_QUEUE);
    }
    
    /**
     * 配置交换机
     *
     * @return
     */
    @Bean
    public DirectExchange messageDirectExchange() {
        return (DirectExchange) ExchangeBuilder.directExchange(MESSAGE_EXCHANGE)
                .durable(true)
                .build();
    }
    ````
    详见 `RabbitMqConfig` 类
    
+ 发送消息类
    <br/>
    ````
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void send(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }

    // 路由模式
    public void send(String exchange, String routeKey, String msg) {
        rabbitTemplate.convertAndSend(exchange, routeKey, msg);
    } 
    
    ``` 
      
### 模式
+  direct：如果路由键完全匹配，消息就被投递到相应的队列
+  fanout：如果交换器收到消息，将会广播到所有绑定的队列上,订阅发布模式
+  topic：可以使来自不同源头的消息能够到达同一个队列。 使用topic交换器时，可以使用通配符，比如：“*” 匹配特定位置的任意文本， “.” 把路由键分为了几部分，“#” 匹配所有规则等。特别注意：发往topic交换器的消息不能随意的设置选择键（routing_key），必须是由"."隔开的一系列的标识符组成。
 