package org.jasmine.sort;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/4
 * @description:
 **/
public class SelectionSort implements Sort<int[]> {

    private int[] arr = new int[]{6, 1, 3, 10, 4, 5, 7, 8, 9};

    @Override
    public int[] sort() {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }

    @Override
    public void print() {

    }
}
