package com.example.rabbitmqserial.handler;

import com.example.rabbitmqserial.vo.PayInfoVo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-19 18:15
 **/
@Component
public class PayInfoVoHandler {

  public static final String exchangeName = "hsg-service-delay";

  @RabbitListener(bindings = @QueueBinding(
      value = @Queue(value = "payInfoVo-test", durable = "true"),
      key = "payInfoVo-test",
      exchange = @Exchange(value = exchangeName, ignoreDeclarationExceptions = "true")),  containerFactory = "rabbitListenerContainerFactory"
  )
  public void delay1(@Payload  String str) {
    System.out.println("RabbitListener delay -- >  ");
    System.out.println(str);
  }

}
