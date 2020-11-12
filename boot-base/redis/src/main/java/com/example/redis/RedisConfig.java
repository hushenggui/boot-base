package com.example.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @program: microservice-framework
 * @description: 配置
 * @author: hushenggui
 * @create: 2020-11-09 17:03
 **/
@Configuration
public class RedisConfig {
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter, @Value("${spring.redis.database}") String dataBase) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //下面这种方式是灵活配置，针对每个库的失效key做处理
        container.addMessageListener(listenerAdapter, new PatternTopic("__keyevent@" + dataBase + "__:expired"));
        return container;
    }

    /**
     * @param
     * @Description TODO 利用反射来创建监听到消息之后的执行方法
     * @Param
     * @Return
     * @Author
     * @Date 15:22 2020/5/25
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisService receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
