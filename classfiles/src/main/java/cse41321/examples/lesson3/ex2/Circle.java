// Circle.java
package cse41321.examples.lesson3.ex2;

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
        return radius - other.radius;
    }
}
