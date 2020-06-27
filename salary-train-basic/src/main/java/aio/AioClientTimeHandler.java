package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioClientTimeHandler implements Runnable, CompletionHandler<Void, AioClientTimeHandler> {

    private AsynchronousSocketChannel asynchronousSocketChannel;

    public AioClientTimeHandler() {
        try {
            asynchronousSocketChannel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        asynchronousSocketChannel.connect(new InetSocketAddress(9999), this, this);
        System.out.println("Connect success...");
    }

    @Override
    public void completed(Void result, AioClientTimeHandler attachment) {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(req.length);

        buffer.put(req);
        buffer.flip();

        asynchronousSocketChannel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                //如果buffer还有内容，表示没发送完，继续发送至成功
                if (buffer.hasRemaining()) {
                    asynchronousSocketChannel.write(buffer, buffer, this);
                } else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    asynchronousSocketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            buffer.flip();

                            byte[] bytes = new byte[buffer.remaining()];
                            buffer.get(bytes);

                            String body;
                            try {
                                body = new String(bytes, StandardCharsets.UTF_8.name());
                                System.out.println("Now is :" + body);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                asynchronousSocketChannel.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    asynchronousSocketChannel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, AioClientTimeHandler attachment) {

    }
}
