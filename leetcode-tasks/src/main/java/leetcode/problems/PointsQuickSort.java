package leetcode.problems;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/9
 * @description:
 **/
public class PointsQuickSort {

    public int[][] kClosest(int[][] points, int K) {
        if (null == points || points.length == 0) {
            return null;
        }
        int[][] ans = topKMinimal(points, 0, points.length, K);
        return Arrays.copyOfRange(ans, 0, K);
    }

    private int[][] topKMinimal(int[][] points, int left, int right, int k) {
        if (left < right) {
            int partitionIndex = partition(points, left, right);
            if (partitionIndex - left + 1 > k) {
                topKMinimal(points, left, partitionIndex, k);
            } else if(partitionIndex - left + 1 < k) {
                topKMinimal(points, partitionIndex + 1, right, k - (partitionIndex - left + 1));
            }
        }
        return points;
    }

    private int partition(int[][] points, int left, int right) {
        int pivot = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        int move = left + 1;
        for (int i = move; i < right; i++) {
            int tmp = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(tmp < pivot) {
                swap(points, i, move);
                move++;
            }
        }
        swap(points, left, move - 1);
        return move - 1;
    }

    private void swap(int[][] arr, int i , int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{2,1},{1,3},{-2,3}};
        int[][] ans = new PointsQuickSort().kClosest(arr, 2);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
