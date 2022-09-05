package es.kiwi.behavioral.visitor.mosh;

public class AnchorNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("highlight-anchor");
    }
}
