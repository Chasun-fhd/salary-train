package leetcode.problems;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/27
 * @description:
 **/
public class IntArrayPlusOne {

    /**
     * 数字不会以0开头，正整数，每一个均为单个数字（0-9）
     * 只有 == 9时，才会产生进位，如果当前位数字 运算之后 == 0，则表示进位了，
     * 尤其是第一个元素最后运算后为0，那么整个数组元素就均为0，只需要原数组扩一位，首位置为0，即为最终结果
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return digits;
        }
        int len = digits.length;
        for (int i = len - 1; i >=0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0 ) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int ret = Integer.bitCount(1*10000000) + 3;
        System.out.println(ret);

        System.out.println(ret % 10000000);
    }
}
