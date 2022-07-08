package com.example.juc.jucdemo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-06-19 17:37
 **/
@Slf4j
public class CreatePool {

  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newCachedThreadPool(new ThreadFactory() {
      private AtomicInteger atomicInteger = new AtomicInteger(1);
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "my_thread_" + atomicInteger.getAndIncrement());
      }
    });

    for (int i = 0; i < 4; i++) {
      int j = i;
      threadPool.execute(() -> {
        try {
          Thread.sleep(1000L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.debug("{}", j);
      });
    }
  }
}
