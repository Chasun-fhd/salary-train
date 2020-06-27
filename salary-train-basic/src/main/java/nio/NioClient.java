package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/26
 * description:
 **/
public class NioClient {

    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress(9999));

        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            int events = selector.select();
            if (events > 0) {
                Set<SelectionKey> keySet = selector.selectedKeys();
                Iterator<SelectionKey> it = keySet.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (key.isConnectable()) {
                        if (channel.isConnectionPending()) {
                            channel.finishConnect();
                        }
                        channel.write(ByteBuffer.wrap("hello,i'm client\n".getBytes()));
                        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    } else if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int cnt = channel.read(buffer);
                        String result = new String(buffer.array(),0, cnt);
                        System.out.println("Client received:" + result);
                    } else if (key.isWritable()) {
                        channel.write(ByteBuffer.wrap("Wow\r\n".getBytes()));
                    }
                    it.remove();
                }

            }
        }
    }
}
