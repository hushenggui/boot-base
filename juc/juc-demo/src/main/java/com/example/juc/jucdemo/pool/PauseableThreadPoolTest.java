package com.example.juc.jucdemo.pool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-06-22 16:42
 **/
public class PauseableThreadPoolTest extends ThreadPoolExecutor {
  //为了保证，我们在修改isPaused的时候，
  private final ReentrantLock lock = new ReentrantLock();
  private boolean isPaused;//标记位，标记线程是否是处于暂停状态；

  private Condition unpausedCondition = lock.newCondition();

  public PauseableThreadPoolTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  public PauseableThreadPoolTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
  }

  public PauseableThreadPoolTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
  }

  public PauseableThreadPoolTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
  }


  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    super.afterExecute(r, t);
  }

  /**
   * 可以实现【暂停逻辑】的方法；
   */
  public void pause() {
    lock.lock();//加锁
    try{
      isPaused = true;//把标记为设为true
    }finally {
      lock.unlock();//解锁
    }
  }

  /**
   * 可以实现【恢复逻辑】的方法；
   */
  public void resume() {
    lock.lock();//加锁
    try {
      isPaused = false;//把标记为设为false
      unpausedCondition.signalAll();//使用signalAll()方法，去唤醒所有的线程；
    }finally {
      lock.unlock();//解锁
    }
  }

  /**
   * 通过该类可以获得的线程池；然后，该线程池中的线程可以去执行任务；那么，在任务执行前，就会执行beforeExecute()方法；
   * @param t
   * @param r
   */
  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    super.beforeExecute(t, r);
    lock.lock();//首先，加锁
    try {
      //如果检测到，isPaused这个标记为为true，就表示我们想让线程暂停了；
      while (isPaused) {
        unpausedCondition.await();//那么，就利用await()方法，去休眠当前线程；
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      lock.unlock();//最后，释放锁
    }
  }
}
