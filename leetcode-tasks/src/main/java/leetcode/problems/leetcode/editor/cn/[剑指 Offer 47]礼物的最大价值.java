package leetcode.problems.leetcode.editor.cn;//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {

    public int maxValue(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int x = grid.length, y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution47().maxValue(grid));
    }

    private void print(int[][] grid) {
        for (int[] items:  grid) {
            System.out.print("[");
           for (int e : items) {
               System.out.print(e+",");
           }
            System.out.print("]\r\n");
        }
        System.out.println("-------------------------------------");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
