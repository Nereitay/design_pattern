package es.kiwi.structural.flyweight.mosh;

import java.util.ArrayList;
import java.util.List;

public class PointService {

    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        Point point = new Point(1, 2, PointType.CAFE, null);
        points.add(point);
        return points;
    }
}
