package com.study.rabbitmq.service;

import com.study.rabbitmq.model.SysUser;
import com.study.rabbitmq.util.UUIDGenUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: microservice-framework
 * @description: rabbitmq生产者
 * @author: hushenggui
 * @create: 2020-07-17 15:03
 **/
@Component
public class RabbitMQProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;


    //普通工作模式
    public void sendMsgWork(){
       /* for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setName("zhangsan");
            sysUser.setRoutingKey("work-direct");
            sysUser.setId(String.valueOf(i));
            rabbitTemplate.convertAndSend(RabbitListenerDirect.exchangeName, "work-direct", sysUser);
        }*/
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan111");
        sysUser.setRoutingKey("work-direct");
        sysUser.setId(UUIDGenUtil.createUUID());
        rabbitTemplate.convertAndSend(RabbitListenerDirect.exchangeName, "work-direct", sysUser);


        sysUser.setName("zhangsan2222");
        sysUser.setRoutingKey("work-direct");
        sysUser.setId(UUIDGenUtil.createUUID());
        rabbitTemplate.convertAndSend(RabbitListenerDirect.exchangeName, "work-direct", sysUser);


        sysUser.setName("zhangsan3333");
        sysUser.setRoutingKey("work-direct");
        sysUser.setId(UUIDGenUtil.createUUID());
        rabbitTemplate.convertAndSend(RabbitListenerDirect.exchangeName, "work-direct", sysUser);


        sysUser.setName("zhangsan4444");
        sysUser.setRoutingKey("work-direct");
        sysUser.setId(UUIDGenUtil.createUUID());
        rabbitTemplate.convertAndSend(RabbitListenerDirect.exchangeName, "work-direct", sysUser);

    }

    //延迟模式 -- 死信队列
    public void sendMsgDelay(){
        //延迟队列
        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setName("zhangsan");
            sysUser.setRoutingKey("work-direct");
            sysUser.setId(String.valueOf(i));
            rabbitTemplate.convertAndSend(RabbitListenerDelay.exchangeName, "queueDelay_delay", sysUser);
        }
    }

    //负载模式
    public void sendMsgFuzai(){
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan");
        sysUser.setRoutingKey("work1");
        rabbitTemplate.convertAndSend("", "work1", sysUser);
    }

    //fanout模式
    public void sendMsgFanout(){
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan");
        sysUser.setRoutingKey("");
        rabbitTemplate.convertAndSend(RabbitListenerFanout.exchangeName, "", sysUser);
    }

    //topic模式
    public void sendMsgTopic(){
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan");
        sysUser.setRoutingKey("work-topic.delay");
        rabbitTemplate.convertAndSend(RabbitListenerTopic.exchangeName, "work-topic.delay", sysUser);
        sysUser.setRoutingKey("work-topic.delay1");
        rabbitTemplate.convertAndSend(RabbitListenerTopic.exchangeName, "work-topic.delay1", sysUser);
        sysUser.setRoutingKey("work-topic.delay2");
        rabbitTemplate.convertAndSend(RabbitListenerTopic.exchangeName, "work-topic.delay2", sysUser);
    }

    //手动确认模式
    public void sendMsgManual(){
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan");
        sysUser.setRoutingKey("manual");
        rabbitTemplate.convertAndSend(RabbitListenerManual.exchangeName, "manual", sysUser);
    }

}
