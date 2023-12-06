package es.kiwi.structural.decorator.example5;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 实现简单的加密
 */
public class EncryptOutputStream2 extends FilterOutputStream {// 更合理的方案，继承装饰器的父类，使用父类提供的功能来协助完成想要的装饰功能
    public EncryptOutputStream2(OutputStream os) {
        //调用父类的构造方法
        super(os);
    }

    @Override
    public void write(int a) throws IOException {
        a = a + 2;
        if (a >= (97 + 26)) {
            a = a - 26;
        }
        //调用父类的方法
        super.write(a);
    }
}
