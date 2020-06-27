package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/26
 * description:
 **/
public class NioServer {

    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9999));

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int events = selector.select();
            if (events > 0) {
                Set<SelectionKey> keySet = selector.selectedKeys();
                Iterator<SelectionKey> it = keySet.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("client connect address:" + socketChannel);
                    } else if (key.isReadable()) {
                        SocketChannel readableChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int read = readableChannel.read(buffer);
                        if (read <= 0) {
                            return;
                        }
                        String result = new String(buffer.array(),0 , read);
                        System.out.println("position:" + buffer.position() + ", limit:" + buffer.limit() + ", cap:" + buffer.capacity());
                        System.out.println("Server received:" + result);
                    } else if (key.isWritable()) {
                        SocketChannel writableChannel = (SocketChannel) key.channel();
                        writableChannel.write(ByteBuffer.wrap("Hello,i'm server\n".getBytes()));
                    }
                    
                    it.remove();
                }
            }
        }

    }
}
