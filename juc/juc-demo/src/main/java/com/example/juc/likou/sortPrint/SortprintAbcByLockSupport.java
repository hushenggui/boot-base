package com.example.juc.likou.sortPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: boot-base
 * @description: 按序打印abc 5次
 * @author: hushenggui
 * @create: 2023-04-20 13:12
 **/
public class SortprintAbcByLockSupport {
  Integer loopNumber;
  ArrayList<Thread> list = new ArrayList<>();

  public SortprintAbcByLockSupport(Integer loopNumber) {
    this.loopNumber = loopNumber;
  }

  private void print() {
    Thread t1 = new Thread(() -> {
      printStr("a");
    });
    Thread t2 = new Thread(() -> {
      printStr("b");
    });
    Thread t3 = new Thread(() -> {
      printStr("c\n");
    });
    list.forEach(thread -> {
      thread.start();
    });
    list.add(t1);
    list.add(t2);
    list.add(t3);
    list.forEach(thread -> {
      thread.start();
    });
  }

  public void printStr(String str) {
    for (int i = 0; i < loopNumber; i++) {
      LockSupport.park();
      System.out.print(str);
      LockSupport.unpark(list.get(getNext(Thread.currentThread())));
    }
  }

  public int getNext(Thread thread) {
    int index = list.indexOf(Thread.currentThread());
    if(index < list.size() - 1) {
      return index + 1;
    }else {
      return 0;
    }
  }

  public static void main(String[] args) {
    SortprintAbcByLockSupport support = new SortprintAbcByLockSupport(5);
    support.print();
    LockSupport.unpark(support.list.get(0));
  }


}
