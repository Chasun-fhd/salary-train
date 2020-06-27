package aio;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioServer {

    public static void main(String[] args) throws InterruptedException {
        AioServerTimeHandler handler = new AioServerTimeHandler();
        new Thread(handler, "AIO-server").start();
        Thread.currentThread().join();
    }
}
