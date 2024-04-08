package com.example.rabbitmqserial.controller;

import com.example.rabbitmqserial.config.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: microservice-framework
 * @description: rabbitmq控制层
 *
 *
 * Jackson2JsonMessageConverter，不兼容老数据，通过它转化发送的，消费者改一下字段后还是能消费，刚开始就不是Jackson2JsonMessageConverter转化发送的数据（旧数据），消费者在修改字段后消费会报类型转化异常。
 *
 * @author: hushenggui
 * @create: 2020-07-17 15:09
 **/
@RestController
public class RabbitController {
    @Autowired
    RabbitMQProducer rabbitMQProducer;

    //工作模式
    @RequestMapping("sendMsgWork")
    public String rabbitmqTest(){
        rabbitMQProducer.sendMsgWork();
        return "sendMsgWork";
    }
}
