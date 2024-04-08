package com.example.kafka.controller;

import com.example.kafka.service.KafkaSimpleProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: microservice-framework
 * @description: kafka控制类
 * @author: hushenggui
 * @create: 2020-07-29 11:08
 **/
@RestController
@RequestMapping("kafka")
public class KafkaController {
    @Autowired
    KafkaSimpleProducerService kafkaSimpleProducerService;

    @RequestMapping("simpleSend")
    public String simpleSend(){
        kafkaSimpleProducerService.sendSimple();
        return "success";
    }
}
