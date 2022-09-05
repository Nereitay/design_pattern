package es.kiwi.structural.flyweight.mosh;

public class Main {

    public static void main(String[] args) {
        PointService service = new PointService();
        for (Point point : service.getPoints()) {
            point.draw();
        }

        System.out.println("-----------Flyweight Pattern-------------");

        PointService1 service1 = new PointService1(new PointIconFactory());
        for (Point1 point : service1.getPoints()) {
            point.draw();
        }
    }
}
