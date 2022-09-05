package es.kiwi.structural.composite.extension.recursive;

/*
组合模式中的递归，指的是对象递归组合，不是常说的递归算法
* */
public class RecursiveTest {

    /**
     *
     * @param a
     * @return
     */
    public int recursive(int a) {
        if (a == 1)
            return 1;

        return a * recursive(a - 1);
    }

    public static void main(String[] args) {
        RecursiveTest test = new RecursiveTest();
        int result = test.recursive(5);
        System.out.println("5的阶乘 = " + result);
    }
}
