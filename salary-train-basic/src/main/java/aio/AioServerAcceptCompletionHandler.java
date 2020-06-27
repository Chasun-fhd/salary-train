package aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioServerAcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AioServerTimeHandler> {

    /**
     * 此方法，在异步io链接请求的资源准备就绪之后，操作系统相关的接口会回调次方法。
     */
    @Override
    public void completed(AsynchronousSocketChannel result, AioServerTimeHandler attachment) {
        /**
         注意此方法 {@line AioServerTimeHandler#doAccept方法中已调用}，到此处重新调用是因为：
         调用AsynchronousServerSocketChannel的accept方法，如果有新的客户端接入，系统将回调我们传入的CompletionHandler实例，
         表示新的客户端已经接入成功。一个AsynchronousServerSocketChannel可以接受成千上万的客户端，所以需要继续调用它的accept方法，
         接收其他的客户端链接，最终形成一个循环。每当接受一个客户端链接成功之后，再异步接受其他客户端链接。
         */
        attachment.serverSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * 异步读
         * @param buffer 接受缓冲区，用于异步从channel中读取数据包；
         * @param buffer attachment，异步channel携带的附件，通知回调的时候作为入参使用
         * @param ReadCompletionHandler 接受通知回调的业务handler，如ReadCompletionHandler
         *
         */
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AioServerTimeHandler attachment) {
        exc.printStackTrace();
    }
}
