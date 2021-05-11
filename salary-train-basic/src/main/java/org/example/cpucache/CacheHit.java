package org.example.cpucache;

import java.util.concurrent.TimeUnit;

/**
 *
 * long 占8个字节，Java中对象头 32位系统占8个字节，64位系统中占用16个字节。
 * 创建long[][6] 二维数组，每一行放6个long 6 * 8 = 48字节 48+16=64字节
 * 一个缓存行64个字节。分别测试命中cpu缓存与否的耗时情况。
 *
 *
 * creator: fenghaidong
 * createdAt: 5/11/21
 * description:
 **/
public class CacheHit {
    //二维数组：
    private static long[][] longs;

    //一维数组长度：
    private static int length = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        //创建二维数组,并赋值：
        longs = new long[length][];
        for (int x = 0; x < length; x++) {
            longs[x] = new long[6];
            for (int y = 0; y < 6; y++) {
                longs[x][y] = 1L;
            }
        }
        cacheHit();
        cacheMiss();
    }

    //缓存命中：
    private static void cacheHit() {
        long sum = 0L;
        long start = System.nanoTime();
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < 6; y++) {
                sum += longs[x][y];
            }
        }
        System.out.println("命中耗时：" + TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start)));
    }

    //缓存未命中：
    private static void cacheMiss() {
        long sum = 0L;
        long start = System.nanoTime();
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < length; y++) {
                sum += longs[y][x];
            }
        }
        System.out.println("未中耗时：" + TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start)));
    }
}
