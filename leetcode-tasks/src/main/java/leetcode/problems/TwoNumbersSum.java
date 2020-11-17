package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/27
 * @description:
 **/
public class TwoNumbersSum {

    /**
     * 双重循环，时间复杂度: O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for ( int j = i+1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 利用hash缓存计算结果，减少遍历次数
     * 时间复杂度: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target-nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    public int max(int[] nums) {
        int max = nums[0];
        for ( int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,4};
        int max = new TwoNumbersSum().max(arr);
        System.out.println(max);

        System.out.println(System.currentTimeMillis());
    }
}
