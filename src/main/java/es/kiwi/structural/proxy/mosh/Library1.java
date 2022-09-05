package es.kiwi.structural.proxy.mosh;

import java.util.HashMap;
import java.util.Map;

public class Library1 {

    private Map<String, Ebook1> ebooks = new HashMap<>();

    public void add (Ebook1 ebook) {
        ebooks.put(ebook.getFileName(), ebook);
    }

    public void openEbook (String fileName) {
        ebooks.get(fileName).show();
    }


}
