package com.example.juc.likou.sortPrint;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.example.juc.likou.sortPrint.SortprintByLockSupport.Foo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import lombok.AllArgsConstructor;

/**
 * @program: boot-base
 * @description: 按序打印
 * @author: hushenggui
 * @create: 2023-04-20 11:25
 **/
public class SortprintByCountDownLatch {
  CountDownLatch second = new CountDownLatch(1);
  CountDownLatch third = new CountDownLatch(2);

  @NoAutoStart
  @AllArgsConstructor
  public class Foo {

    public void first() {
      System.out.println("=================== first");
    }

    public void second() {
      System.out.println("=================== second");
    }

    public void third() {
      System.out.println("==================== third");
    }

  }

    public void run() throws Exception {
      new Thread(() -> {
        Foo foo = new Foo();
        foo.first();
        second.countDown();
        third.countDown();
      }).start();

      new Thread(() -> {
        try {
          second.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Foo foo = new Foo();
        foo.second();
        third.countDown();
      }).start();

      new Thread(() -> {
        try {
          third.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Foo foo = new Foo();
        foo.first();
      }).start();
    }


  public static void main(String[] args) throws Exception {
    System.out.println("kaishi ============================");
    SortprintByCountDownLatch sortprint = new SortprintByCountDownLatch();
    sortprint.run();
  }

}
