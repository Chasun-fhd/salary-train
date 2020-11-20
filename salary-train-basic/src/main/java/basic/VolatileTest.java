package basic;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/17
 * @description:
 **/
public class VolatileTest {

    private volatile int n = 1;
    private int c = 2;

    public void hello() {
        int a = 1;
        int b = n;
        if (b == 1) {
            System.out.println("hello:n:" + n);
        }
    }
}
