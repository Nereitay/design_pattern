package es.kiwi.Structural.flyweight.mosh;

import java.util.ArrayList;
import java.util.List;

public class PointService1 {

    private PointIconFactory iconFactory;

    public PointService1(PointIconFactory iconFactory) {
        this.iconFactory = iconFactory;
    }

    public List<Point1> getPoints() {
        List<Point1> points = new ArrayList<>();
        Point1 point = new Point1(1, 2, iconFactory.getPointIcon(PointType.CAFE));
        points.add(point);
        return points;
    }
}
