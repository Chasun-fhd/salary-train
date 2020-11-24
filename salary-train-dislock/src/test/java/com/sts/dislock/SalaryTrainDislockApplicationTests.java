package com.sts.dislock;

import com.sts.dislock.redis.RedisLock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@ContextConfiguration(classes = SalaryTrainDislockApplication.class)
class SalaryTrainDislockApplicationTests {

    @Autowired
    private RedisLock redisLock;

    @Test
    void contextLoads() throws Exception{

        Executor executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> redisLock.tryLock(100, TimeUnit.MILLISECONDS));
        }
        Thread.currentThread().join(2000);
        System.out.println("final result:" + redisLock.getCnt());
    }

}
