package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioServerTimeHandler implements Runnable {

    AsynchronousServerSocketChannel serverSocketChannel;

    public AioServerTimeHandler() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9999));
            System.out.println("AIo-Server listen on 9999");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        doAccept();
    }

    private void doAccept() {
        serverSocketChannel.accept(this, new AioServerAcceptCompletionHandler());
    }
}
