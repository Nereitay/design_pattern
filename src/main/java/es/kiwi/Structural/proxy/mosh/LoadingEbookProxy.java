package es.kiwi.Structural.proxy.mosh;

public class LoadingEbookProxy implements Ebook1{
    private String fileName;
    private RealEbook ebook;

    public LoadingEbookProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show() {
        if (ebook == null) {
            ebook = new RealEbook(fileName);
        }

        System.out.println("Logging");

        ebook.show();
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
