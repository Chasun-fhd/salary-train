package org.jasmine.io;

import com.google.common.base.Charsets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/18
 * @description:
 **/
public class BIOClient {

    public static void main(String[] args) throws Exception {
        /*for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {*/
                    sendRequest();
        /*        } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        */
        Thread.currentThread().join();
    }

    private static void sendRequest() throws Exception {
        Socket socket = new Socket("localhost", 7878);
        socket.setTcpNoDelay(true);
        socket.setReceiveBufferSize(23);
        OutputStream os = socket.getOutputStream();
        os.write(("Hi, server. i am client").getBytes(Charsets.UTF_8));

        InputStream is = socket.getInputStream();
        int contentLen = is.available();
        ByteBuffer buff = ByteBuffer.allocate(contentLen);
        byte[] bytes = new byte[contentLen];
        is.read(bytes);
        buff.put(bytes);
        System.out.println(buff.array().length);
        if (buff.hasArray()) {
            System.out.println("client received:" + new String(buff.array(), Charsets.UTF_8));
        }
    }
}
