package com.example.kafka.service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @program: microservice-framework
 * @description: kafka简单消费者
 * @author: hushenggui
 * @create: 2020-07-29 11:09
 **/
@Component
@Slf4j
public class KafkaSimpleConsumeService {

    /*    @KafkaListener(groupId = "cuntomer1", topicPartitions = {
            @TopicPartition(topic = "monitor", partitions = { "0" })
        }, concurrency = "5")
        public void consumer(ConsumerRecord consumerRecord) {
            log.info(consumerRecord.toString());
            log.info("【当前线程id11111111】：{}", Thread.currentThread().getId());
            Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
            if(kafkaMassage.isPresent()){
                Object o = kafkaMassage.get();
                log.info("kafka consumer11111111 message {}",o);
            }
        }


        @KafkaListener(groupId = "cuntomer2", topicPartitions = {
            @TopicPartition(topic = "monitor", partitions = { "0" })
        }, concurrency = "5")
        public void consumer1(ConsumerRecord consumerRecord){
            log.info(consumerRecord.toString());
            log.info("【当前线程id222222】：{}", Thread.currentThread().getId());
            Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
            if(kafkaMassage.isPresent()){
                Object o = kafkaMassage.get();
                log.info("kafka consumer2222222 message {}",o);
            }
        }*/
    @KafkaListener(groupId = "cuntomer1", topicPartitions = {
        @TopicPartition(topic = "monitor", partitions = { "0" })
    }, concurrency = "5", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(List<String> list) {
        log.info("【当前线程id11111111】：{}", Thread.currentThread().getId());
        log.info(list.toString());
    }

}
