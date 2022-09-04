package es.kiwi.Behavioral.visitor.mosh;

public class HeadingNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("highlight-heading");
    }
}
