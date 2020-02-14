// Circle.java
package cse41321.examples.lesson3.ex3;

public class Circle implements Comparable<Circle> {
    private int radius;
    private int x;
    private int y;

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

        // What if I'd like to compare by position on the x or y axis?
        // Can't do this with Comparable interface
    }
}
