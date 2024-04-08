package com.example.juc.likou.sortPrint;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import java.util.concurrent.locks.LockSupport;
import lombok.AllArgsConstructor;

/**
 * @program: boot-base
 * @description: 按序打印
 * @author: hushenggui
 * @create: 2023-04-20 09:20
 **/
public class SortprintByLockSupport {

  public static Thread t1, t2, t3;

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


  public void run() {

    t1 = new Thread(() -> {
      Foo foo = new Foo();
      foo.first();
      LockSupport.unpark(t2);
    });

    t2 = new Thread(() -> {
      LockSupport.park();
      Foo foo = new Foo();
      foo.second();
      LockSupport.unpark(t3);
    });

    t3 = new Thread(() -> {
      LockSupport.park();
      Foo foo = new Foo();
      foo.third();
    });
    t1.start();
    t2.start();
    t3.start();
  }

  public static void main(String[] args) {
    System.out.println("kaishi ============================");
    SortprintByLockSupport sortprint = new SortprintByLockSupport();
    sortprint.run();
  }

}
