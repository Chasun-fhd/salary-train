package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * creator: fenghaidong
 * createdAt: 2020/9/5
 * description:
 **/
public class ThreadPoolTests {

    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(1, 3, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(4),
                (r) -> {
                    Thread th = new Thread(r);
                    return th;
                }, new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 5; i++) {
            final AtomicInteger cnt = new AtomicInteger(i);
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ">Hello, i'm thread -" + cnt);
                try {
                    Thread.sleep(10 * 1000);
                } catch ( Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
