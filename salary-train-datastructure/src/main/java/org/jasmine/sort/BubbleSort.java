package org.jasmine.sort;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/3
 * @description:
 **/
public class BubbleSort implements Sort<int[]> {

    private int[] arr = new int[]{1, 3, 4, 2, 2, 7, 7, 5, 8, 6, 9, 10};

    @Override
    public int[] sort() {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        for (int i = 1; i < len; ++i) {
            for (int j = i - 1; j < len - i - 1; ++j) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[i];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    @Override
    public void print() {
        int[] arrs = sort();
        for (int e : arrs) {
            System.out.print(e + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new BubbleSort().print();
    }
}
