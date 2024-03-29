package com.study.rabbitmq.service;

import com.study.rabbitmq.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: microservice-framework
 * @description: 监听类       验证主题模式
 * @author: hushenggui
 * @create: 2020-07-17 14:59
 **/
@Component
@Slf4j
public class RabbitListenerDelay {

    //
    public static final String exchangeName = "hsg-service-delay";
    public static final String QUEUEDELAY_DELAY = "queueDelay_delay";
    public static final String QUEUEDELAY = "queueDelay";


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queueDelay", durable = "true"),
            key = "queueDelay",
            exchange = @Exchange(value = exchangeName, ignoreDeclarationExceptions = "true"))
    )
    public void delay1(SysUser sysUser) {
        System.out.println();
        System.out.println("RabbitListener delay1 -- >  ");
        System.out.println(sysUser);
        if(sysUser.getId().equals("6")) {
            throw new RuntimeException();
        }
    }


   /* @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queueDelay_delay", durable = "true",
                    arguments = {@Argument(name = "x-dead-letter-exchange",value = exchangeName),
                            @Argument(name = "x-dead-letter-routing-key",value = "policyRevert"),
                            @Argument(name = "x-message-ttl",value = "60000")}),
            exchange = @Exchange(value = exchangeName, ignoreDeclarationExceptions = "true"))
    )
    public void delay2(SysUser sysUser) {
        System.out.println();
        System.out.println("RabbitListener delay2 -- >  ");
        System.out.println(sysUser);
    }*/
}
