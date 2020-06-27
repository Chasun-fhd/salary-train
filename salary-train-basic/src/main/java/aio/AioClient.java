package aio;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioClient {

    public static void main(String[] args) throws Exception{
        AioClientTimeHandler clientTimeHandler = new AioClientTimeHandler();
        new Thread(clientTimeHandler).start();

        Thread.currentThread().join();
    }
}
