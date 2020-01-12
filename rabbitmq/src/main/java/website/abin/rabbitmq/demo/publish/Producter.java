package website.abin.rabbitmq.demo.publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author zhbin
 * @Description
 * @Date 2020-01-07 18:53
 */
public class Producter {

    // 定义交换机的名字
    public static final String EXCHANGE_NAME="byte003";
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
        // 定义一个交换机，类型是fanout
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        // 因为消息先发到交换机，交换机没有保存功能，所以如果没有消费者，消息会丢失
        channel.basicPublish(EXCHANGE_NAME,"",null,"发布订阅模式的消息".getBytes());

        channel.close();
        connection.close();
    }
}
