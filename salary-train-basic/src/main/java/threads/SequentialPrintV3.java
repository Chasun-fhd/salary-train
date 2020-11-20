package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/18
 * @description:
 **/
public class SequentialPrintV3 {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();
    private static volatile int state = 0;

    public static void main(String[] args) {
        new SequentialPrintV3().print();
    }

    public void print() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Worker(lock, conditionA, conditionB, 'A', 0, 10));
        threadPool.execute(new Worker(lock, conditionB, conditionC, 'B', 1, 10));
        threadPool.execute(new Worker(lock, conditionC, conditionA, 'C', 2, 10));

        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdownNow();
    }

    public static class Worker implements Runnable {
        private final ReentrantLock lock;
        private final Condition current;
        private final Condition next;
        private final char value;
        private final int targetState;
        private final int cnt;

        public Worker(ReentrantLock lock, Condition current, Condition next, char value, int targetState, int cnt) {
            this.lock = lock;
            this.current = current;
            this.next = next;
            this.value = value;
            this.targetState = targetState;
            this.cnt = cnt;
        }

        @Override
        public void run() {
            try {
                this.lock.lock();
                for (int i = 0; i < cnt; i++) {
                    while (targetState != state) {
                        current.await();
                    }
                    System.out.print(this.value);
                    state++;
                    next.signal();
                    if (state >= 3) {
                        System.out.println();
                    }
                    state = state % 3;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }
    }
}
