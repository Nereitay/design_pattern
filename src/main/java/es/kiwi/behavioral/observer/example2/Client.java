package es.kiwi.behavioral.observer.example2;

public class Client {

    public static void main(String[] args) {
        //创建一个报纸，作为被观察者
        Newspaper subject = new Newspaper();
        //创建阅读者，也就是观察者
        Reader reader1 = new Reader();
        reader1.setName("Apple");
        Reader reader2 = new Reader();
        reader2.setName("Banana");
        Reader reader3 = new Reader();
        reader3.setName("Cherry");

        //注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        //要出报纸啦
        subject.setContent("This issue's content is the Observer pattern");

    }
}
