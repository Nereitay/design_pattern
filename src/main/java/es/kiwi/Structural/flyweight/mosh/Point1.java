package es.kiwi.Structural.flyweight.mosh;

public class Point1 {

    private int x; // 4 bytes
    private int y; // 4 bytes
    private PointIcon icon;

    public Point1(int x, int y, PointIcon icon) {
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void draw() {
        System.out.printf("%s at (%d, %d)", icon.getType(), x, y);
    }
}
