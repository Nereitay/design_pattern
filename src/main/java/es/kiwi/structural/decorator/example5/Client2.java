package es.kiwi.structural.decorator.example5;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Client2 {
    public static void main(String[] args) {
       /* try (DataOutputStream dout = new DataOutputStream(
                new EncryptOutputStream( // 换了个位置， 输出文件一片空白
                        new BufferedOutputStream(
                                new FileOutputStream("MyEncrypt.txt"))))) {

            dout.write("abcdxyz".getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        try (DataOutputStream dout = new DataOutputStream(
                new EncryptOutputStream2( // 可以任意调换位置
                        new BufferedOutputStream(
                                new FileOutputStream("MyEncrypt.txt"))))) {

            dout.write("abcdxyz".getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
