package es.kiwi.Structural.composite.mosh;

public class Shape1 implements Component{

    @Override
    public void render() {
        System.out.println("Render Shape");
    }

    @Override
    public void move() {
        System.out.println("move shape");

    }
}
