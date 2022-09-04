package es.kiwi.Structural.proxy.mosh;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        String[] fileNames = {"a", "b", "c"};

        for (String fileName : fileNames) {
            library.add(new Ebook(fileName));
        }

        library.openEbook("a");

        System.out.println("-----------Proxy Pattern----------");

        Library1 library1 = new Library1();

        for (String fileName : fileNames) {
            library1.add(new EbookProxy(fileName));
        }

        library1.openEbook("a");

        for (String fileName : fileNames) {
            library1.add(new LoadingEbookProxy(fileName));
        }

        library1.openEbook("a");

    }
}
