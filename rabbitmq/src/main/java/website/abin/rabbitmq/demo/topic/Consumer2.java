package website.abin.rabbitmq.demo.topic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author zhbin
 * @Description
 * @Date 2020-01-07 18:58
 */
public class Consumer2 {
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

        String queueName = "queue006";
        channel.queueDeclare(queueName,false,false,false,null);

        // 绑定队列到交换机
        channel.queueBind(queueName,EXCHANGE_NAME,"key.#");
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
                System.out.println("消费者2："+s);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
