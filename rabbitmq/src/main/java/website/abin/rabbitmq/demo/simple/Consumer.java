package website.abin.rabbitmq.demo.simple;

import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * @Author zhbin
 * @Description
 * @Date 2020-01-07 10:39
 */
public class Consumer {

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

        // 4. 创建出消息队列
        /**
         * 第一个参数是消息队列的名称
         * 第二个参数表示消息是否持久化
         * 第三个参数标识消息队列是否被channel独占
         * 第四个参数标识是否自动删除消息队列，当消息队列没有绑定交换机后是否自动删除
         * 第五个是消息队列扩展参数
         */
        String queueName = "byte001";
        channel.queueDeclare(queueName, true, false, false, null);

        // 5. 创建消费者,对消息进行处理
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
                System.out.println("获取到的消息："+s);
            }
        };
        // 6. 通过channel消费者和消息队列关联
        /**
         * 第一个参数是消息队列的名字
         * 第二个参数是否自动签收（即消费消息后告知服务器已被消费）
         * 第三个参数是消费者
         */
        channel.basicConsume(queueName, true, consumer);
    }
}
