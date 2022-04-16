package com.example.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @program: microservice-framework
 * @description: kafka简单生产者
 * @author: hushenggui
 * @create: 2020-07-29 11:10
 **/
@Service
@Slf4j
public class KafkaSimpleProducerService {
    @Autowired
    KafkaTemplate kafkaTemplate;

    /**
    * @Description:
    * @Param: []
    * @return:
    * @Author: hushenggui
    * @Date: 2020/7/29
    */
    public void sendSimple(){
        try {
            log.info("logVo {}", "开始发送");
            for (int i = 0; i < 20; i++) {
                kafkaTemplate.send("monitor", "hsg", "monitor--ceshi:" + i);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
