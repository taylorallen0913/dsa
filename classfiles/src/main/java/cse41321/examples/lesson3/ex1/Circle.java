// Circle.java
package cse41321.examples.lesson3.ex1;

public class Circle implements Comparable<Circle> {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int compareTo(Circle other) {
        if (radius < other.radius) {
            return -1;
        }
        if (radius > other.radius) {
            return 1;
        }
        return 0;
    }
}
