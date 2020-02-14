package cse41321.homework.homework3;

import java.util.Comparator;

public class DescendingMpgComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        return Integer.compare(b.mpg, a.mpg);
    }
}
