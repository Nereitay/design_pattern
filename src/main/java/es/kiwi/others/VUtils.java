package es.kiwi.others;


import org.junit.Test;

public class VUtils {

    public static ThrowExceptionFunction isTrue(boolean b) {
        return (errorMessage) -> {
            if (b) {
                throw new RuntimeException(errorMessage);
            }
        };
    }

    public static BranchHandler isTrueOrFalse(boolean b) {
        return ((trueHandler, falseHandler) -> {
            if (b)
                trueHandler.run();
            else
                falseHandler.run();
        });
    }

    @Test
    public void isTrue1() {
        isTrue(false).throwMessage("参数为false，不显示");
    }

    @Test
    public void isTrue2() {
        isTrue(true).throwMessage("参数为true，抛异常");
    }

    @Test
    public void isTrueOrFalse() {
        isTrueOrFalse(false).trueOrFalseHandle(() -> {
            System.out.println("True处理方式");
        }, () -> {
            System.out.println("False处理方式");
        });
    }

}

@FunctionalInterface
interface ThrowExceptionFunction{
    void throwMessage(String message);
}

@FunctionalInterface
interface BranchHandler {
    void trueOrFalseHandle(Runnable trueHandler, Runnable falseHandler);
}
