package cse41321.homework.homework3;

import java.util.Comparator;

public class MakeDescendingMpgComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        int result = a.make.compareTo(b.make);
        if (result == 0) {
            result = Integer.compare(b.mpg, a.mpg);
        }
        return result;
    }
}
