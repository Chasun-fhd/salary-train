package bits;

import org.junit.Test;

/**
 * @author: haidong.feng
 * @createdAt: 2020/10/9
 * @description:
 **/
public class BitsOperation {

    @Test
    public void addByBits() {
        System.out.println(3<<1);
    }

    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
