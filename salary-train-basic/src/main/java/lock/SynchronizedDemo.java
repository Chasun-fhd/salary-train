package lock;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/19
 * @description:
 **/
public class SynchronizedDemo {

    private static final Object obj = new Object();

    /**
     * 同步方法
     */
    public synchronized void hello (String e) {
        System.out.println("hello");
    }
    /**
     *
     */
    public void hello2() {
        synchronized (obj) {
            System.out.println("hello2");
        }
    }
}
