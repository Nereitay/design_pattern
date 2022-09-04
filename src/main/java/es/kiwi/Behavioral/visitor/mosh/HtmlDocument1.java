package es.kiwi.Behavioral.visitor.mosh;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument1 {

    private List<HtmlNode1> nodes = new ArrayList<>();

    public void add(HtmlNode1 node) {
        nodes.add(node);
    }

    public void execute(Operation operation) {
        nodes.forEach(node ->  node.execute(operation));
    }
}
