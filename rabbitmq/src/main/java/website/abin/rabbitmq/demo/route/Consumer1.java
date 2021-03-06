package website.abin.rabbitmq.demo.route;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author zhbin
 * @Description
 * @Date 2020-01-07 18:58
 */
public class Consumer1 {
    public static final String EXCHANGE_NAME="byte004";

    public static void main(String[] args) throws Exception {


        // 1. 创建出链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        // 2. 通过链接工厂创建链接对象
        Connection connection = factory.newConnection();

        // 3. 通过链接对象创建出channel
        Channel channel = connection.createChannel();

        String queueName = "queue005";
        channel.queueDeclare(queueName,false,false,false,null);

        // 绑定队列到交换机
        /**
         * 参数3是routingkey，只有和它一样的routingkey的消息才会被当前消费者收到
         */
        channel.queueBind(queueName,EXCHANGE_NAME,"key1");
        // 如果要接收多个routingkey的消息，在执行一次上面的代码即可，如下
        channel.queueBind(queueName,EXCHANGE_NAME,"key2");
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /**
             * consumerTag 用来标识.可以再监听队列时候设置
             * envelope 信封,通过envelope可以通过这个获取到很多东西
             * properties 额外的消息属性
             * body:消息体
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String s = new String(body, "UTF-8");
                System.out.println("消费者1："+s);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
