package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/18
 * @description:
 **/
public class SequentialPrintV2 {

    private static final Object lock = new Object();
    private static volatile int state = 1;

    public static void main(String[] args) throws Exception {
        new SequentialPrintV2().print();
    }

    public void print() throws Exception{
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Worker(lock, 10, 'A'));
        threadPool.execute(new Worker(lock, 10, 'B'));
        threadPool.execute(new Worker(lock, 10, 'C'));

        Thread.currentThread().join(1000);
        threadPool.shutdownNow();
    }


    public static class Worker implements Runnable {
        private final Object lock;
        private final int count;
        private final char value;

        public Worker(Object lock, int count, char value) {
            this.lock = lock;
            this.count = count;
            this.value = value;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.count; i++) {
                if (this.value == 'A') {
                    synchronized (this.lock) {
                        while (state != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(this.value);
                        state = 2;
                        lock.notifyAll();
                    }
                } else if (this.value == 'B') {
                    synchronized (this.lock) {
                        while (state != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(this.value);
                        state = 3;
                        lock.notifyAll();
                    }
                } else if (this.value == 'C') {
                    synchronized (this.lock) {
                        while (state != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(this.value);
                        state = 1;
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
