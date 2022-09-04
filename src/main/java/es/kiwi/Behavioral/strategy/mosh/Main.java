package es.kiwi.Behavioral.strategy.mosh;

public class Main {

    public static void main(String[] args) {
        ImageStorage2 imageStorage = new ImageStorage2(
                new PngCompressor(), new BlackAndWhiteFilter());
        imageStorage.Store("a");

        System.out.println("---------------");

        ImageStorage3 imageStorage2 = new ImageStorage3();
        imageStorage2.Store("a", new PngCompressor(), new BlackAndWhiteFilter());

    }
}
