package es.kiwi.behavioral.visitor.mosh;

public class Main {

    public static void main(String[] args) {
        HtmlDocument document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());
        document.highlight();

        System.out.println("----------Visitor Pattern-----------");

        HtmlDocument1 document1 = new HtmlDocument1();
        document1.add(new HeadingNode1());
        document1.add(new AnchorNode1());
        document1.execute(new HighlightOperation());
        document1.execute(new PlainTextOperation());
    }
}
