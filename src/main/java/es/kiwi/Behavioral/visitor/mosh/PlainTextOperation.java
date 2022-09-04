package es.kiwi.Behavioral.visitor.mosh;

public class PlainTextOperation implements Operation{
    @Override
    public void apply(HeadingNode1 heading) {
        System.out.println("text-heading");
    }

    @Override
    public void apply(AnchorNode1 anchor) {
        System.out.println("text-anchor");

    }
}
