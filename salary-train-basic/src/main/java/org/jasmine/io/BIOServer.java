package org.jasmine.io;

import com.google.common.base.Charsets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/18
 * @description:
 **/
public class BIOServer {

    private static final ExecutorService executor = new ThreadPoolExecutor(10, 100,
            5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(256), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7878);
        while (true) {
            Socket socket = serverSocket.accept();
            socket.setTcpNoDelay(true);
            socket.setSendBufferSize(23);
            executor.submit(() -> {
                InputStream is;
                OutputStream os;
                try {
                    is = socket.getInputStream();
                    int contentLen = is.available();
                    ByteBuffer buff = ByteBuffer.allocate(contentLen);
                    byte[] bytes = new byte[contentLen];
                    is.read(bytes);
                    buff.put(bytes);
                    if (buff.hasArray()) {
                        System.out.println("Server received:" + new String(buff.array(), Charsets.UTF_8));
                    }
                    os = socket.getOutputStream();
                    os.write("Hi, Client. i am server".getBytes(Charsets.UTF_8));
                    os.flush();
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
