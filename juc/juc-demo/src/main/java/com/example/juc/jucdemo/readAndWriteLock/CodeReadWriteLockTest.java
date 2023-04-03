package com.example.juc.jucdemo.readAndWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-03-07 15:13
 **/
public class CodeReadWriteLockTest {

  public static void main(String[] args) throws InterruptedException {

    DataContainer dataContainer = new DataContainer();

    Thread t1 = new Thread(() -> {
      dataContainer.read();
//            dataContainer.write();
    }, "t1");

//        Thread.sleep(100);

    Thread t2 = new Thread(() -> {
//            dataContainer.read();
      dataContainer.write();
    }, "t2");

    t1.start();
    t2.start();

  }

}

@Slf4j(topic = "c.DataContainer")
class DataContainer {

  private Object object = new Object();
  private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
  private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

  public Object read() {
    readLock.lock();
    log.info("拿到读锁！");
    try {
      log.info("读取操作 ...");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } finally {
      readLock.unlock();
      log.info("释放读锁！");
    }
    return object;
  }

  public void write() {
    writeLock.lock();
    log.info("拿到写锁！");
    try {
      log.info("写操作 ... ");
    } finally {
      writeLock.unlock();
      log.info("释放写锁！");
    }
  }


}
