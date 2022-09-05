package es.kiwi.behavioral.iterator.mosh;

public class BrowseHistory3 {

    private String[] urls = new String[10];
    private int count;

    public void push(String url) {
        urls[count++] = url;

    }

    public String pop() {
        return urls[--count];
    }

    public Iterator createiterator() {
        return new ArrayIterator(this);
    }


    public class ArrayIterator implements Iterator<String> {

        private BrowseHistory3 history;

        private int index;

        public ArrayIterator(BrowseHistory3 history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.urls.length);
        }

        @Override
        public String current() {
            return history.urls[index];
        }

        @Override
        public void next() {
            index ++;
        }
    }
}
