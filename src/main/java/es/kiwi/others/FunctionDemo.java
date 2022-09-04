package es.kiwi.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Function,Consumer,Predicate,Supplier接口示范
 */
public class FunctionDemo {

    static int functionTest1(int valueToBeOperated, Function<Integer, Integer> function) {
        return function.apply(valueToBeOperated);
    }

    static Integer functionTest2(int value, Function<Integer, Integer> function1,
                                 Function<Integer, Integer> function2) {
        // value作为functional的参数，返回一个结果，该结果作为function2的参数，返回一个最终结果
        return function1.andThen(function2).apply(value);
    }

    static void consumerTest(int value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    static boolean predicateTest1(int value, Predicate<Integer> predicate) {
        return predicate.test(value);
    }

    static void predicateTest2(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + "");
            }
        }
    }

    static boolean validInput(String name, Predicate<String> function) {
        return function.test(name);
    }

    static String supplierTest(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        int myNumber = 10;

        // 使用lambda表达式实现函数式接口
        int res1 = functionTest1(myNumber, (x) -> x + 20);
        System.out.println(res1);


        //使用匿名内部类实现
        int res2 = functionTest1(myNumber, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t + 20;
            }
        });
        System.out.println(res2);


        System.out.println(functionTest2(3, val -> val * 2, val -> val + 3));//9


        consumerTest(3, x -> System.out.println(x * 2));

        System.out.println(predicateTest1(3, x -> x == 3));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据：");
        predicateTest2(list, n -> true);
        System.out.println("输出所有偶数 ：");
        predicateTest2(list, n -> n % 2 == 0);
        System.out.println("输出大于3的所有数字：");
        predicateTest2(list, n -> n > 3);

        String name = "黎明";
        if (validInput(name, s -> !s.isEmpty() && s.length() <= 3))
            System.out.println("名字输入正确");

        System.out.println(supplierTest(() -> name.length() + ""));

        MyFunction myFunction = (a, b, c) -> a + b + c;
        int result = myFunction.opThree(1, 2, 3);
        System.out.println(result);

    }
}

@FunctionalInterface
interface MyFunction {

    int opThree(int a, int b, int c);
}


