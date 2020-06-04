package org.jasmine;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class App {

    static final char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws Exception {
        //initWrite();
        File file = new File("E:/tmp/data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line = null;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null && line.trim().length() > 0) {
            builder.append(line);
            ++lineNumber;
            System.out.println(builder.length() + "-" + (lineNumber << 1) * 15);
        }
    }

    static void initWrite() throws Exception {
        File file = new File("E:/tmp/data.txt");
        if (file.exists()) {
            file.delete();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < 655360; i++) {
            String line = random16Strs();
            writer.write(line, 0, line.length());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }


    static String random16Strs() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (++i < 16) {
            int idx = random.nextInt(0, arr.length - 1);
            builder.append(arr[idx]);
        }
        return builder.toString();
    }
}
