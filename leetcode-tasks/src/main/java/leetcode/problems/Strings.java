package leetcode.problems;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/2
 * @description:
 **/
public class Strings {

    public static void main(String[] args) {
        int ret = new Strings().count(3, 7);
        System.out.println(ret);

        System.out.println((int)'a');
        System.out.println((int)'z');
    }

    public int count(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m-1 || j == n-1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
