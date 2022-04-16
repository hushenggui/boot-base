package com.example.rabbitmqserial.config;

import com.example.rabbitmqserial.handler.PayInfoVoHandler;
import com.example.rabbitmqserial.vo.PayInfoVo;
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
        PayInfoVo payInfoVo = new PayInfoVo();
        payInfoVo.setAccountName("hushenggui");
        payInfoVo.setBankName("pingan");
        payInfoVo.setBankAccount("123456");
        rabbitTemplate.convertAndSend(PayInfoVoHandler.exchangeName, "payInfoVo-test", payInfoVo);
    }
}
