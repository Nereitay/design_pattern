package es.kiwi.Behavioral.iterator.mosh;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory2 {

    private List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public String pop() {
        int lastIndex = urls.size() - 1;
        String lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);

        return lastUrl;
    }

    public Iterator createiterator() {
        return new ListIterator(this);
    }


    public class ListIterator implements Iterator<String> {

        private BrowseHistory2 history;

        private int index;

        public ListIterator(BrowseHistory2 history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            index ++;
        }
    }
}
