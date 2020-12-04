package com.sts.dislock;

import java.util.PriorityQueue;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/24
 * @description:
 **/
public class UnitTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b-a);
        q.offer(2);
        q.offer(4);
        q.offer(1);
        q.offer(3);

        for (Integer e : q) {
            System.out.println(e);
        }
    }
}
