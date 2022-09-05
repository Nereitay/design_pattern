package es.kiwi.structural.adapter.mosh;

import es.kiwi.structural.adapter.mosh.avaFilters.Caramel;

public class Main {

    public static void main(String[] args) {
        ImageView imageView = new ImageView(new Image());
        imageView.apply(new VividFilter());

        System.out.println("------------Adapter Pattern------------");

        imageView.apply(new CaramelAdapter());

        System.out.println("------------Favor Composition over Inheritance------------");
        imageView.apply(new CaramelFilter(new Caramel()));


    }
}
