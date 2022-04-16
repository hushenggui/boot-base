package com.example.juc.jucdemo.GuardedService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-03-27 15:12
 **/
@Slf4j(topic = "juc")
public class Test {

  final static Object obj = new Object();

  public static void main(String[] args) throws InterruptedException {

    new Thread(() -> {
      synchronized (obj) {
        try {
          while (true) {
            Thread.sleep(6000);
            log.debug("kaishi1111111111111  ------------");
            //int i = 1/0;
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    }, "t1").start();


    new Thread(() -> {
      synchronized (obj) {
        while (true) {
          try {
            Thread.sleep(6000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          //LockSupport.park();
          log.debug("kaishi222222222222222222  ------------");
        }
      }
    }, "t2").start();

    Thread.sleep(1000);
  }

}
