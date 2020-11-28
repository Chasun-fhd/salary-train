package com.sts.dislock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/24
 * @description:
 **/
@Component
public class RedisLock {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private volatile int cnt;

    public boolean tryLock(long ttl, TimeUnit timeUnit) {
        String value = UUID.randomUUID().toString().concat("-"+Thread.currentThread().getId());
        try {
            boolean success = redisTemplate.opsForValue().setIfAbsent("hello", value, ttl, timeUnit);
            System.out.println(String.format("Thread[%s] acquire lock [%s]: %b", Thread.currentThread().getId(),  value,success));
            if (success) {
                cnt++;
                System.out.println(String.format("Thread[%s] incr cnt to: %d", Thread.currentThread().getId(), cnt));
            }
        } catch (Exception e ) {
           e.printStackTrace();
        } finally {
            if (Objects.equals(redisTemplate.opsForValue().get("hello"), value)) {
                System.out.println(String.format("Thread[%s] begin to release lock", Thread.currentThread().getId()));
                redisTemplate.expire("hello", 1, TimeUnit.MILLISECONDS);
                System.out.println(String.format("Thread[%s] release lock finished", Thread.currentThread().getId()));
            }
        }
        return true;
    }

    public int getCnt() {
        return cnt;
    }
}
