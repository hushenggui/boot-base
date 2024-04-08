package com.example.redis.redisson;

import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2024-02-22 10:43
 **/
@Service
public class RedissonManager {
  @Autowired
  private RedissonClient redissonClient;

  /**
   * 加锁
   *
   * @param lockKey
   * @return
   */
  public RLock lock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock();
    return lock;
  }

  /**
   * 释放锁
   *
   * @param lockKey
   */
  public void unlock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.unlock();
  }

  /**
   * 释放锁
   *
   * @param lock
   */
  public void unlock(RLock lock) {
    lock.unlock();
  }

  /**
   * 带超时的锁
   *
   * @param lockKey
   * @param timeout 超时时间   单位：秒
   */
  public RLock lock(String lockKey, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, TimeUnit.SECONDS);
    return lock;
  }

  /**
   * 带超时的锁
   *
   * @param lockKey
   * @param unit    时间单位
   * @param timeout 超时时间
   */
  public RLock lock(String lockKey, TimeUnit unit, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, unit);
    return lock;
  }

  /**
   * 尝试获取锁
   *
   * leaseTime 必须是 -1 才会开启 Watch Dog 机制，也就是如果你想开启 Watch Dog 机制必须使用默认的加锁时间为 30s。如果你自己自定义时间，超过这个时间，锁就会自定释放，并不会延长。
   *
   * @param lockKey
   * @param waitTime  最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   * @return
   */
  public boolean tryLock(String lockKey, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * 尝试获取锁
   *
   * @param lockKey
   * @param unit      时间单位
   * @param waitTime  最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   * @return
   */
  public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, unit);
    } catch (InterruptedException e) {
      return false;
    }
  }

}
