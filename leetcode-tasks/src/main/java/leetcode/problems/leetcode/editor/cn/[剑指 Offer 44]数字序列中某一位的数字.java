package leetcode.problems.leetcode.editor.cn;//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 73 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {

    public int findNthDigit(int n) {
        if (n <= 0) return n;
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();
        q.push_back(1);
        q.push_back(2);
        q.push_back(3);

        int max = q.max_value();
        int p = q.pop_front();
        max = q.max_value();
    }


   static class MaxQueue {

        private Node head;
        private Node max;
        private Node current;


        public MaxQueue() {
            head = new Node(-1);
            max = new Node(Integer.MIN_VALUE);
        }

        public int max_value() {
            if (null == max) return -1;
            return max.val;
        }

        public void push_back(int value) {
            if (current == null) {
                current = new Node(value);
            } else {
                current.next = new Node(value);
            }
            if (value > max.val) {
                max = current.next;
            }
        }

        public int pop_front() {
            head = head.next;
            return head.val;
        }
    }

    static class Node {

        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
