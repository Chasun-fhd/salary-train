package leetcode.problems.leetcode.editor.cn;//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJO46 {

    public int translateNum(int num) {
        if (num < 0) return 0;
        if (num == 0) return 1;
        return recursive(num);
    }


    private int recursive(int num) {
        if (num < 10) return 1;
        if (num % 100 < 26 && num % 100 > 9) return recursive(num / 10) + recursive(num/100);
        return recursive(num / 10);
    }

    public static void main(String[] args) {
        int ret = new SolutionJO46().translateNum(12258);
        System.out.println(ret);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
