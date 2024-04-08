package com.example.juc.jucdemo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @program: boot-base
 * @description: 基础工厂类
 * @author: hushenggui
 * @create: 2023-08-11 16:52
 **/
public class CustomThreadFactory implements ThreadFactory {

  private static final AtomicInteger poolNumber = new AtomicInteger(1);
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  private final String namePrefix;

  CustomThreadFactory() {
    namePrefix = "pool-" +
        poolNumber.getAndIncrement() +
        "-thread-";
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement()) {
      @Override
      public void run() {
        try {
          super.run();
        } catch (Exception e) {
          System.out.println("异常信息：" + e.getMessage());
        }
      }
    };
    if (t.isDaemon())
      t.setDaemon(false);
    if (t.getPriority() != Thread.NORM_PRIORITY)
      t.setPriority(Thread.NORM_PRIORITY);

    return t;
  }

}
