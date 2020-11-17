package leetcode.problems;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/11
 * @description:
 **/
public class CutRope {

    public int cuttingRope(int n) {
        if ( n < 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int lengthOfThree = n % 3 == 1 ?  n / 3 - 1 : n / 3;
        int lengthOfTwo = (n - lengthOfThree * 3) / 2;
        long ans = (fastPow(2, lengthOfTwo) % 1000000007) * (fastPow(3, lengthOfThree) % 1000000007);
        return (int) (ans % 1000000007);
    }

    private int fastPow(int x, int p) {
        if ( p == 0) {
            return 1;
        }
        long base = x;
        int n = p;
        long res = 1L;
        if ( n < 0) {
            n = -n;
        }
        while (n != 0) {
            if ((n & 1 ) == 1) {
                res *= base;
                res %= 1000000007;
            }
            base *= base;
            n = n / 2;
        }
        res = res % 1000000007;
        res = p > 0 ? res : 1 / res;
        return (int)res;
    }

    public static void main(String[] args) {
        new CutRope().cuttingRope(120);
    }
}
