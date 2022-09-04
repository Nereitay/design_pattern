package es.kiwi.Behavioral.strategy.mosh;

public class ImageStorage {

    private String compressor;

    private String filter;

    public ImageStorage(String compressor, String filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void Store (String fileName) {
        //JPEG, PNG, ...
        //B&W, High Contrast

        if (compressor.equals("jpeg")) {
            System.out.println("Compressing using JPEG");
        } else if (compressor.equals("png")) {
            System.out.println("Compressing using PNG");
        }

        if (filter.equals("b&w")) {
            System.out.println("Applying B&W filter");
        } else if (compressor.equals("high-contrast")) {
            System.out.println("Applying High Contrast filter");
        }
    }
}
