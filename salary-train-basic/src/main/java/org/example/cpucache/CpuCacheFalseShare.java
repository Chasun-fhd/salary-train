package org.example.cpucache;

/**
 * creator: fenghaidong
 * createdAt: 5/11/21
 * description:
 **/
public class CpuCacheFalseShare implements Runnable {

    //线程数、数组大小：
    public static int NUM_THREADS = 4; // change

    //数组迭代的次数：
    public final static long ITERATIONS = 500L * 1000L * 1000L;

    //线程需要处理的数组元素角标：
    private final int handleArrayIndex;

    //操作数组：
    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    //对数组的元素进行赋值：
    static{
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public CpuCacheFalseShare(final int handleArrayIndex) {
        this.handleArrayIndex = handleArrayIndex;
    }

    //启动线程，每一个线程操作一个数组的元素，一一对应：
    public static void main(final String[] args) throws Exception {
        //程序睡眠必须加上：
        Thread.sleep(10000);

        final long start = System.nanoTime();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CpuCacheFalseShare(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(System.nanoTime() - start);
    }

    //对数组的元素进行操作：
    public void run() {
        long i = ITERATIONS;
        while (0 != --i) {
            longs[handleArrayIndex].value = i;
        }
    }

    //数组元素：
    public final static class VolatileLong {
        public volatile long value = 0L;
        //public long p1, p2, p3, p4, p5; //代码1
        /**
         * 64位系统为例
         * volatileLong 对象占用内存  ObjectHeader(16bytes) + value(8bytes) + p1-p5(40bytes) 共64bytes
         * VolatileLong[4] 数组中，一个VolatileLong对象刚好占一个缓存行，当四个线程分别访问0 1 2 3 下表对象时，
         * 对象是分布在不同缓存行中。
         * 如果将上述p1 p2 p3 p4 p5 注释掉，数组元素很大几率分布在同一个缓存行中，当被不同的cpu访问，即会出现伪共享。
         * 性能差别很大，近两倍。
         * 未注释：18975784264
         * 已注释：35297994235
         */
    }
}
