package leetcode.problems.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2884 👎 0
// baabad
// dabaab

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    public String longestPalindrome(String s) {
        if (s == null) return s;
        int len = s.length();
        boolean[][] valid = new boolean[len][len];
        //边界条件:
        //len = 1  true  len = 2  s[i] == s[j] true
        //len >= 3  dp[i+1, j-1] = true && s[i]==s[j]
        String ans = "";
        for (int m = 0; m < len; ++m) {
            for (int i = 0; i + 1 < len; ++i) {
                int j = i + 1;
                if (m == 0) {
                    valid[i][j] = true;
                } else if (m == 1) {
                    valid[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    valid[i][j] = valid[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }

                if (valid[i][j] && m+1 > ans.length()) {
                    ans = s.substring(i, i+m+1);
                }
            }
        }
        return ans;
    }

    private String bruteForce(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        int maxLen = 1, start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > maxLen && isValidPalindrome(chars, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private boolean isValidPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("ababa"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
