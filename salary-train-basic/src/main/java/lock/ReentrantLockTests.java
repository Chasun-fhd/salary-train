package lock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/10
 * @description:
 **/
public class ReentrantLockTests {

    private static volatile int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Executor threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(ReentrantLockTests::incr);
        }
        Thread.currentThread().join(2000);
        System.out.println("final cnt:" + cnt);
    }

    public static void incr() {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        try {
            cnt++;
            System.out.println(Thread.currentThread().getName() + ":cnt:" + cnt);
        } finally {
            lock.unlock();
        }
    }
}
