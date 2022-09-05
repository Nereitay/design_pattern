package es.kiwi.behavioral.iterator.mosh;

public class Main {

    public static void main(String[] args) {
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        for (int i = 0; i < history.getUrls().size(); i++) {
            String s = history.getUrls().get(i);
            System.out.println(s);
        }

        System.out.println("-------------Using Iterator pattern -----------");

        BrowseHistory2 history2 = new BrowseHistory2();
        history2.push("a");
        history2.push("b");
        history2.push("c");

        Iterator iterator = history2.createiterator();
        while (iterator.hasNext()) {
            Object url = iterator.current();
            System.out.println(url);
            iterator.next();
        }

        BrowseHistory3 history3 = new BrowseHistory3();
        history3.push("a");
        history3.push("b");
        history3.push("c");

        Iterator iterator2 = history3.createiterator();
        while (iterator2.hasNext()) {
            Object url = iterator2.current();
            System.out.println(url);
            iterator2.next();
        }
    }
}
