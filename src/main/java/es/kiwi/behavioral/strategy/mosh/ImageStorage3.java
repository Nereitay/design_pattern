package es.kiwi.behavioral.strategy.mosh;

public class ImageStorage3 {

    public void Store(String fileName, Compressor compressor, Filter filter) {
        //JPEG, PNG, ...
        //B1&W, High Contrast

        compressor.compress(fileName);

        filter.apply(fileName);
    }
}
