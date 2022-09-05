package es.kiwi.structural.composite.mosh;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Object> shapes = new ArrayList<>();

    public void add(Object shape) {
        shapes.add(shape);
    }

    public void render() {
        shapes.forEach(obj -> {
            if (obj instanceof Shape)
                ((Shape) obj).render();
            else
                ((Group)obj).render();
        });
    }
}
