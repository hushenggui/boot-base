package com.example.juc.jucdemo.pool;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-03-16 11:08
 **/
public class Test {

  public static void main(String[] args) {
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    System.out.println("11111111111111111");
    executor.schedule(new Runnable() {
      @Override
      public void run() {
        System.out.println("33333333333333");
      }
    },10, TimeUnit.SECONDS);
    System.out.println("22222222222222222222222");
    executor.shutdown();
  }

}
