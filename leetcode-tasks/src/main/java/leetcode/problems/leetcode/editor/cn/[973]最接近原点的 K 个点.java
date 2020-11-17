package leetcode.problems.leetcode.editor.cn;//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 143 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        if (null == points || points.length == 0) {
            return null;
        }
        //calculate distance.
        int[] distances = new int[points.length];
        int j = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int[] p : points) {
            distances[j] = p[0] * p[0] + p[1] * p[1];
            memo.put(j, distances[j]);
            j++;
        }
        Arrays.sort(distances);
        print(distances);
        int[][] ans = new int[K][2];
        int m = 0;
        for (int i = 0; i < K; i++) {
            for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
                if (Objects.equals(entry.getValue(), distances[i])) {
                    ans[m++] = points[entry.getKey()];
                }
            }
        }
        return ans;
    }

    private void buildMaxHeap(int[] distances) {
        int len = distances.length;
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(distances, 0, len);
        }
    }

    private void heapify(int[] arr, int start, int len) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int largest = start;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != start) {
            swap(arr, start, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-5, 4}, {-3, 2}, {0, 1}, {-3, 7}, {-2, 0}, {-4, -6}, {0, -5}};
        int[][] ans = new Solution973().kClosest(points, 6);
        for (int[] an : ans) {
            System.out.println(an[0] +"," + an[1]);
        }
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println(" ");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
