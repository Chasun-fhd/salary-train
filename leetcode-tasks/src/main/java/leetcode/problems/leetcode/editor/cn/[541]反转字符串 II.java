package leetcode.problems.leetcode.editor.cn;//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
//  len <= k reverse all
//  k <= len < 2k reverse [0, k-1]
//  2k <= len   reverse [0,k-1] [k, Math.min(2k-1, len-4k)
//  len % 2k == 0 ? len / 2k :
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution541 {

    public String reverseStr(String s, int k) {
        if (k < 0 || s == null || s.trim().length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length, times = len / (2 * k), rests = len - times * 2 * k;
        int start, end;
        for (int i = 0; i < times; i++) {
            start = i * 2 * k;
            end = i * 2 * k + k-1;
            reverse(chars, start, end);
        }
        if (rests == 0) {
            return new String(chars);
        }
        start = times * 2 * k;
        if (rests < k) {
            end = len - 1;
        } else {
            end = start + (k - 1);
        }
        reverse(chars, start, end);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        //System.out.println("start:" + start + ", end:" + end);
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefghlmnkkl";
        String res = new Solution541().reverseStr(s, 2);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
