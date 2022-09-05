package es.kiwi.creational.prototype.mosh;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle1 implements Component1{

    private int radius;

    @Override
    public void render() {
        System.out.println("Rendering a circle");
    }

    @Override
    public Component clone() {
        Circle newCircle = new Circle();
        newCircle.setRadius(radius);
        return newCircle;
    }
}
