package es.kiwi.Behavioral.visitor.mosh;

public class HeadingNode1 implements HtmlNode1{

    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
