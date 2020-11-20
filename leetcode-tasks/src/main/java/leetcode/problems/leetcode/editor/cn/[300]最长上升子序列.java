package leetcode.problems.leetcode.editor.cn;//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1161 👎 0


import sun.misc.VM;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        //dp array
        int[] dp = new int[nums.length];
        //init minimum len = 1
        dp[0] = 1;
        //max len
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            while (left <= nums.length - 1 && nums[left - 1] < nums[left]) {
                ans = Math.max(ans, left - i + 1);
                System.out.println("left:" + left + ", i:" + i);
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,2,3};
        int ret = new Solution300().lengthOfLIS(arr);
        System.out.println(ret);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
