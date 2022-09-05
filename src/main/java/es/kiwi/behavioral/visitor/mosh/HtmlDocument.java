package es.kiwi.behavioral.visitor.mosh;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {

    private List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node) {
        nodes.add(node);
    }

    public void highlight() {
        nodes.forEach(HtmlNode :: highlight);
    }
}
