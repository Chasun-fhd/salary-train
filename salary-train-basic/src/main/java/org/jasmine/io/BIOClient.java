package org.jasmine.io;

import com.google.common.base.Charsets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/18
 * @description:
 **/
public class BIOClient {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    sendRequest();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.currentThread().join();
    }

    private static void sendRequest() throws Exception {
        Socket socket = new Socket("localhost", 7878);
        OutputStream os = socket.getOutputStream();
        os.write(("Hi, server. i am client").getBytes(Charsets.UTF_8));

        InputStream is = socket.getInputStream();
        byte[] buff = new byte[is.available()];
        is.read(buff);
        System.out.println(new String(buff, Charsets.UTF_8));
    }
}
