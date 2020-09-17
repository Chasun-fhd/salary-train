package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/7
 * @description:
 **/
public class ThreadPoolTests {

    public static void main(String[] args) {
        int coreSize = 1 ;
        int maxSize = 2;
        int queueSize = 2;
        long aliveTime = 5;

        final AtomicInteger threadCnt = new AtomicInteger(1);

        ExecutorService threadPool = new ThreadPoolExecutor(coreSize, maxSize, aliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize), (r) -> {
            Thread t = new Thread(r);
            t.setName("TT-"+threadCnt.getAndIncrement());
            return t;
        }, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 5; i++ ) {
            threadPool.execute(() -> {
                if (Thread.currentThread().getName().endsWith("1")) {
                    int a = 1/0;
                }
                System.out.println(Thread.currentThread().getName()+ ">> hello");
                try {
                    Thread.sleep(1*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
