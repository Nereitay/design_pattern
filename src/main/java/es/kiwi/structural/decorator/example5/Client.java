package es.kiwi.structural.decorator.example5;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Client {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                        new EncryptOutputStream(
                                new FileOutputStream("MyEncrypt.txt"))))) {

            dout.write("abcdxyz".getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
