package es.kiwi.creational.prototype.mosh;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle implements Component{

    private int radius;

    @Override
    public void render() {
        System.out.println("Rendering a circle");
    }
}
