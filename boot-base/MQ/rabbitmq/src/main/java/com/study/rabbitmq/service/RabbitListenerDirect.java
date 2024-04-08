package com.study.rabbitmq.service;

import com.rabbitmq.client.Channel;
import com.study.rabbitmq.model.SysUser;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpIOException;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @program: microservice-framework
 * @description: 监听类       验证工作模式  -->  一个交换机一个队列， 多个消费者监听  不绑定key的情况
 * @author: hushenggui
 * @create: 2020-07-17 14:59
 **/
@Component
@Slf4j
public class RabbitListenerDirect {
    //
    public static final String exchangeName = "hsg-service-direct";

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "work-direct", durable = "true"),
            key = "work-direct",
            exchange = @Exchange(value = exchangeName, ignoreDeclarationExceptions = "true"))
    )
    public void work1(@Payload SysUser sysUser, @Headers Map<String,Object> headers, Channel channel) {

        try {
            System.out.println("RabbitListener direct1 -- >  ");
            System.out.println(sysUser);
            if(sysUser.getName().equals("zhangsan3333")) {
                String a = null;
                System.out.println(a.length());
                System.out.println();
            }
        }catch (Exception e) {
            log.error("1111111111111111111111111111111");
           // test1();

        }finally {
            //反馈消息的状态
            try {
                //channel.basicAck((Long) headers.get(AmqpHeaders.DELIVERY_TAG),false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void test1() {
        try {
            String a = null;
            System.out.println(a.length());
        } catch (Exception e) {
            log.error("222222222222222222222222222222222");
            throw new AmqpIOException(new IOException());
        }

    }
}
