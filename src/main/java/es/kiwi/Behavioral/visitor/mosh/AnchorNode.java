package es.kiwi.Behavioral.visitor.mosh;

public class AnchorNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("highlight-anchor");
    }
}
