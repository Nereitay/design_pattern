package es.kiwi.structural.composite.mosh;

public class Main {

    public static void main(String[] args) {

        Group group1 = new Group();
        group1.add(new Shape()); //Square
        group1.add(new Shape()); //Square

        Group group2 = new Group();
        group2.add(new Shape()); //Circle
        group2.add(new Shape()); //Circle

        Group group = new Group();
        group.add(group1);
        group.add(group2);

        group.render();

        System.out.println("-----------------Composite pattern--------------");

        Group1 group3 = new Group1();
        group3.add(new Shape1()); //Square
        group3.add(new Shape1()); //Square

        Group1 group4 = new Group1();
        group4.add(new Shape1()); //Circle
        group4.add(new Shape1()); //Circle

        Group1 group5 = new Group1();
        group5.add(group3);
        group5.add(group4);

        group5.render();
        group5.move();


    }
}
