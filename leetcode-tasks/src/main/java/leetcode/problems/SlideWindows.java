package leetcode.problems;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/27
 * @description:
 **/
public class SlideWindows {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,9,4,5,7};
        new SlideWindows().slideWindow(arr, arr.length, 3);
    }

    private void slideWindow(int[] arr, int size, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = 0, max = 0;
        for (int i = 0; i < size - k; i++) {
            max = arr[i];
            List<Integer> tmp = new ArrayList<>();
            for (j = i+1; j <= k; j++) {
                tmp.add(arr[j]);
                if (arr[i + j] > max) {
                    max = arr[i+j];
                }
            }
            ans.add(tmp);
        }
        System.out.println("max:" + max);
        System.out.println("arr:" + JSONObject.toJSONString(ans));
    }
}
