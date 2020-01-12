package website.abin.rabbitmq.demo.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author zhbin
 * @Description 消息生成者
 * @Date 2020-01-07 10:26
 */
public class Producter {

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
        // 4. 通过channel发布消息
        /**
         * 四个参数：
         * 第一个参数是交换机的名称
         * 第二个参数是路由键
         * 第三个参数标识消息的一些额外的属性
         * 第四个是消息的具体的内容
         */
        String message = "字节";
        for(int i = 0;i < 5;i ++){

            channel.basicPublish("","byte001",null,message.getBytes());
        }
        // 5. 释放资源，释放channel 和 链接对象

        channel.close();
        connection.close();
    }
}
