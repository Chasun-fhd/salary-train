package threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/24
 * @description:
 **/
public class ThreadPools {

    private ThreadPoolExecutor executor;


    public static void main(String[] args) throws InterruptedException {
        new ThreadPools().selfDefineRejectedHandler();
        //Thread.currentThread().join(10000);
    }

    public void selfDefineRejectedHandler() {
        executor = new ThreadPoolExecutor(2, 8, 500, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10), new SendToQueueIfRejectionOccurHandler());
        executor.allowCoreThreadTimeOut(true);
        final AtomicInteger incr = new AtomicInteger(0);
        int cnt = 0;
        while (cnt++ < 20) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (Thread.currentThread().isInterrupted()) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("I'm a little thread-" + Thread.currentThread().getName() +", seq:" + incr.getAndIncrement());
            });
        }
    }


    private static class SendToQueueIfRejectionOccurHandler implements RejectedExecutionHandler {

        private Executor threadPools = Executors.newFixedThreadPool(10);

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            threadPools.execute(() -> {
               new RejectionDelivery().execute();
            });
        }
    }

    private static class RejectionDelivery {
        public void execute() {
            System.out.println("Send to queue...");
        }
    }
}
