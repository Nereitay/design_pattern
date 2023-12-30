package es.kiwi.behavioral.strategy.mosh;

public class ImageStorage2 {

    private Compressor compressor;

    private Filter filter;

    public ImageStorage2(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void Store (String fileName) {
        //JPEG, PNG, ...
        //B1&W, High Contrast

        compressor.compress(fileName);

        filter.apply(fileName);
    }
}
