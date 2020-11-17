package leetcode.problems;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/9
 * @description:
 **/
public class QuickSort {

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,
                4,
                13,
                25,
                41,
                52,
                58};
        int[] sortedArr = new QuickSort().quickSort(arr, 0, arr.length);
        System.out.println(JSONObject.toJSONString(sortedArr));
    }
}
