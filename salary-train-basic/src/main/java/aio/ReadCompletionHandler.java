package aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel socketChannel) {
        this.asynchronousSocketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);

        try {
            String req = new String(body, StandardCharsets.UTF_8.name());

            System.out.println("The time server received order : " + req);

            String currentTime = "Query Time Order".equalsIgnoreCase(req) ? new Date().toString() : "Bad order";

            byte[] bytes = currentTime.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();
            asynchronousSocketChannel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    //如果没发送完，则继续发送，直到发送成功
                    if (attachment.hasRemaining()) {
                        asynchronousSocketChannel.write(buffer, buffer, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        if (Objects.nonNull(asynchronousSocketChannel)) {
                            asynchronousSocketChannel.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
        try {
            if (Objects.nonNull(asynchronousSocketChannel)) {
                asynchronousSocketChannel.close();
            }
        } catch (Exception e) {

        }
    }
}
