package es.kiwi.Structural.decorator.extension.javaIO;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 自己实现的I/O流的装饰器 ---- 第二版
 *
 * 实现简单的加密
 */
public class EncryptOutputStream2 extends FilterOutputStream {

    public EncryptOutputStream2(OutputStream os) {
        //调用父类的构造方法
        super(os);
    }

    @Override
    public void write(int b) throws IOException {
        //先统一向后移动两位
        b = b + 2;
        //97是小写的a的码值
        if (b >= (97 + 26)) {
            //如果大于，表示已经是y或者z了，减去26就回到a或者b了
            b = b - 26;
        }
        //调用父类的方法
        super.write(b);
    }
}
