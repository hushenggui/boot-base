package com.example.redis.redisson.executor;

import com.example.redis.redisson.executor.AbstractLockExecutor;
import io.vavr.control.Try;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * description: Redisson 分布式锁
 *
 * @author zhouxinlei
 * @since 2022-05-03 09:11:03
 */
@Slf4j
@RequiredArgsConstructor
public class RedissonLockExecutor extends AbstractLockExecutor<RLock> {

    private final RedissonClient redissonClient;

    @Override
    public boolean renewal() {
        return true;
    }

    @Override
    public RLock acquire(String lockKey, String lockValue, long expire, long acquireTimeout) {
        final RLock lockInstance = redissonClient.getLock(lockKey);
        return Try.of(() -> {
            final boolean locked = lockInstance.tryLock(acquireTimeout, expire, TimeUnit.MILLISECONDS);
            return obtainLockInstance(locked, lockInstance);
        }).getOrElseGet(throwable -> {
            log.error("Redisson lock failed：", throwable);
            return null;
        });
    }

    @Override
    public boolean releaseLock(String key, String value, RLock lockInstance) {
        if (lockInstance.isHeldByCurrentThread()) {
            return Try.of(() -> lockInstance.forceUnlockAsync().get()).getOrElseGet(throwable -> {
                log.error("Redisson releaseLock failed：", throwable);
                return false;
            });
        }
        return false;
    }
}
