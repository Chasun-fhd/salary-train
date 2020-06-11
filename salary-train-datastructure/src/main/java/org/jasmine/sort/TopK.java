package org.jasmine.sort;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/11
 * @description:
 **/
public class TopK {

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }

    /**
     * O(n)  时间复杂度内求无序数组中的第 K  大元素。比如， 4 ， 2 ， 5 ， 12 ， 3  这样一组数据，第 3  大元素就是 4 。
     *
     * @param arr
     */
    public static int sort(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return 0;
        }
        int p = partition(arr, l, r);
        if ((p + 1) == k) {
            return arr[p];
        } else if ((p + 1) < k) {
            return sort(arr, p + 1, r, k);
        } else {
            return sort(arr, l, p - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 6, 7, 4};
        int topK = sort(arr, 0, arr.length - 1,5);
        System.out.println(topK);
    }
}
