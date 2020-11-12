package com.example.redis;

/**
 * @program: microservice-framework
 * @description: ji
 * @author: hushenggui
 * @create: 2020-11-09 17:52
 * <p>
 * 针对redis数据失效事件，进行数据处理
 * @param message
 * @param pattern
 */
//@Component
/*public class RedisListener extends KeyExpirationEventMessageListener {

    public RedisListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    *//**
 * 针对redis数据失效事件，进行数据处理
 * @param message
 * @param pattern
 *//*
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        System.out.println("expiredKey ------------- " + expiredKey);

    }

}*/
