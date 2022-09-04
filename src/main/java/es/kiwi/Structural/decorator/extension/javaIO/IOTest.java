package es.kiwi.Structural.decorator.extension.javaIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/*Java中典型的装饰模式应用  ----> I/O流*/
public class IOTest {
    public static void main(String[] args) throws Exception{

        //流式读取文件
        DataInputStream din = null;
        try {
            din = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("IOTest.txt")
                    )
            );
            //然后就可以获取文件内容了
            byte[] bs = new byte[din.available()];
            din.read(bs);
            String content = new String(bs);
            System.out.println("文件内容====" + content);

        } finally {
            din.close();
        }
    }
}
