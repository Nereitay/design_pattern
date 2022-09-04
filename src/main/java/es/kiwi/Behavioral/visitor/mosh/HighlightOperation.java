package es.kiwi.Behavioral.visitor.mosh;

public class HighlightOperation implements Operation{
    @Override
    public void apply(HeadingNode1 heading) {
        System.out.println("highlight-heading");
    }

    @Override
    public void apply(AnchorNode1 anchor) {
        System.out.println("highlight-anchor");
    }
}
