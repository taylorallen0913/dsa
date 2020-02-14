package cse41321.homework.homework3;

import cse41321.algorithms.QuickSort;

/**
 * Demonstrate sorting cars using quicksort.
 *
 * Program output:
 * Unsorted
 * Toyota Camry 33
 * Ford Focus 40
 * Honda Accord 34
 * Ford Mustang 31
 * Honda Civic 39
 * Toyota Prius 48
 * Honda Fit 35
 * Toyota Corolla 35
 * Ford Taurus 28
 *
 * Make then model
 * Ford Focus 40
 * Ford Mustang 31
 * Ford Taurus 28
 * Honda Accord 34
 * Honda Civic 39
 * Honda Fit 35
 * Toyota Camry 33
 * Toyota Corolla 35
 * Toyota Prius 48
 *
 * Descending MPG
 * Toyota Prius 48
 * Ford Focus 40
 * Honda Civic 39
 * Toyota Corolla 35
 * Honda Fit 35
 * Honda Accord 34
 * Toyota Camry 33
 * Ford Mustang 31
 * Ford Taurus 28
 *
 * Make then descending MPG
 * Ford Focus 40
 * Ford Mustang 31
 * Ford Taurus 28
 * Honda Civic 39
 * Honda Fit 35
 * Honda Accord 34
 * Toyota Prius 48
 * Toyota Corolla 35
 * Toyota Camry 33
 */
public class Homework3 {

    private static final Car[] cars = {
            new Car("Toyota", "Camry", 33),
            new Car("Ford", "Focus", 40),
            new Car("Honda", "Accord", 34),
            new Car("Ford", "Mustang", 31),
            new Car("Honda", "Civic", 39),
            new Car("Toyota", "Prius", 48),
            new Car("Honda", "Fit", 35),
            new Car("Toyota", "Corolla", 35),
            new Car("Ford", "Taurus", 28)
    };

    public static void main(String[] args) {
        displayCars("Unsorted");

        QuickSort.quickSort(cars, new MakeModelComparator());
        displayCars("Make then model");

        QuickSort.quickSort(cars, new DescendingMpgComparator());
        displayCars("Descending MPG");

        QuickSort.quickSort(cars, new MakeDescendingMpgComparator());
        displayCars("Make then descending MPG");
    }

    private static void displayCars(String title) {
        System.out.println(title);
        for (Car car : cars) {
            System.out.printf("%s %s %d\n", car.make, car.model, car.mpg);
        }
        System.out.println();
    }
}
