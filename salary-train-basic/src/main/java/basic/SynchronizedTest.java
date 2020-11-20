package basic;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/18
 * @description:
 **/
public class SynchronizedTest {
    public void hello() {
        //锁住SynchronizedTest的class对象
        synchronized (SynchronizedTest.class) {
            //调用静态方法
            method();
        }
    }
    //锁住SynchronizedTest的class对象
    synchronized static void method() {
    }
}
