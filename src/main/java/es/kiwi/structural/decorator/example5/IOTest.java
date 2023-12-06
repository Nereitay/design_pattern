package es.kiwi.structural.decorator.example5;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class IOTest {

    public static void main(String[] args) {
        String path = IOTest.class.getClassLoader().getResource("IOTest.txt").getPath();
        System.out.println(path);
        try (DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            byte[] bs = new byte[din.available()];
            din.read(bs);
            String content = new String(bs);
            System.out.println("文件内容 ==== " + content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
