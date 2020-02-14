package cse41321.homework.homework3;

import java.util.Comparator;

public class MakeModelComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        int result = a.make.compareTo(b.make);
        if (result == 0) {
            result = a.model.compareTo(b.model);
        }
        return result;
    }
}
