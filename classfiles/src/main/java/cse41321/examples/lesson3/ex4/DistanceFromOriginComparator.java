// DistanceFromOriginComparator.java
package cse41321.examples.lesson3.ex4;

import java.util.Comparator;

// Compare two circles using distance from origin
public class DistanceFromOriginComparator implements Comparator<Circle> {
    public int compare(Circle c1, Circle c2) {
        if (c1.getDistanceFromOrigin() < c2.getDistanceFromOrigin()) {
            return -1;
        }
        if (c1.getDistanceFromOrigin() > c2.getDistanceFromOrigin()) {
            return 1;
        }
        return 0;
    }
}
