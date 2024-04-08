package com.example.juc.likou.sortPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: boot-base
 * @description: 按序打印abc 5次
 * @author: hushenggui
 * @create: 2023-04-20 13:12
 **/
public class SortprintAbc {

  Thread t1, t2, t3;
  ReentrantLock lock = new ReentrantLock();
  Condition conditionA = lock.newCondition();
  Condition conditionB = lock.newCondition();
  Condition conditionC = lock.newCondition();


  public void a() {
    System.out.println("a");
  }

  public void b() {
    System.out.println("b");
  }

  public void c() {
    System.out.println("c");
  }


  public synchronized void run(int number) {
    t1 = new Thread(() -> {
      try {
        conditionA.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      a();
      conditionB.signal();
    });
    t2 = new Thread(() -> {
      try {
        conditionB.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      b();
      conditionC.signal();
    });
    t3 = new Thread(() -> {
      try {
        conditionC.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      c();
    });
    t1.start();
    t2.start();
    t3.start();
  }


  public static void main(String[] args) {
    SortprintAbc sortprintAbc = new SortprintAbc();
    sortprintAbc.run(5);
    for (int i = 0; i < 5; i++) {
      sortprintAbc.conditionA.signal();
    }
  }

}
