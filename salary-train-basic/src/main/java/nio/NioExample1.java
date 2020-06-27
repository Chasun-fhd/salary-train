package nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/22
 * description:
 **/
public class NioExample1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < buffer.capacity(); i++) {
            int rand = secureRandom.nextInt(20);
            buffer.put(rand);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
