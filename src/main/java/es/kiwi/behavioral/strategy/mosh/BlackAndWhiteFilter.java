package es.kiwi.behavioral.strategy.mosh;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.println("Applying B1&W filter");
    }
}
