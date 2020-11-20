package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/18
 * @description:
 **/
public class SequentialPrintV1 {

    private ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception{
        new SequentialPrintV1().print();
    }


    public void print() throws Exception {
        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);
        threadPool.execute(new Worker(a,b, "A", 10));
        threadPool.execute(new Worker(b,c, "B", 10));
        threadPool.execute(new Worker(c,a, "C", 10));

        Thread.currentThread().join(1000);
        threadPool.shutdown();
    }

    public static class Worker implements Runnable {
        private Semaphore current;
        private Semaphore next;
        private String value;
        private int count;

        public Worker(Semaphore current, Semaphore next, String value, int count) {
            this.current = current;
            this.next = next;
            this.value = value;
            this.count = count;
        }

        @Override
        public void run() {
            int cnt = 0;
            while (cnt++ < count) {
                try {
                    current.acquire(); //current-1;
                    System.out.print(value);
                    if (value.equals("C")) {
                        System.out.println();
                    }
                    next.release(); //next+1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
