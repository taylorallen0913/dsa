package cse41321.homework;

/**
 * CSE 41321 Homework #3
 * @author Taylor Allen
 * @version 2-4-20
 */

// QuickSort algorithm from lecture notes
import cse41321.algorithms.QuickSort;

import java.util.Comparator;

/**
 * Compares 2 cars by make in ascending order, and if make equal, compares two cars by model in ascending order
 */
class CompareCarsByMakeThenModel implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        // If car1's make is greater than car2's make
        if(car1.make.compareToIgnoreCase(car2.make) > 0) {
            return 1;
        }
        // If car2's make is greater than car1's make
        if(car1.make.compareToIgnoreCase(car2.make) < 0) {
            return -1;
        }
        // If car1's make and car2's make are equal
        if(car1.make.compareToIgnoreCase(car2.make) == 0) {
            // If car1's model is greater than car2's model
            if(car1.model.compareToIgnoreCase(car2.model) > 0) {
                return 1;
            }
            // If car2's model is greater than car1's model
            else if(car1.model.compareToIgnoreCase(car2.model) < 0) {
                return -1;
            }
        }
        // Both car1's make and model is the same as car2's make and model
        return 0;
    }
}

/**
 * Compares 2 cars in descending order by MPG
 */
class CompareCarsByDescendingMPG implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        // If car1's mpg is greater than car2's mpg
        if(car1.mpg > car2.mpg) {
            return -1;
        }
        // If car2's mpg is greater than car1's mpg
        if(car1.mpg < car2.mpg) {
            return 1;
        }
        // If car1's mpg is the same as car2's mpg
        return 0;
    }
}

/**
 * Compares 2 cars by make in ascending order, and if equal, compares two cars by MPG in descending order.
 */
class CompareCarsByMakeThenDescendingMPG implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        // If car1's make is greater than car2's make
        if(car1.make.compareToIgnoreCase(car2.make) > 0) {
            return 1;
        }
        // If car2's make is greater than car1's make
        if(car1.make.compareToIgnoreCase(car2.make) < 0) {
            return -1;
        }
        // If car1's make is equal to car2's make
        if(car1.make.compareToIgnoreCase(car2.make) == 0) {
            // If car1's mpg is greater than car2's mpg
            if(car1.mpg > car2.mpg) {
                return -1;
            }
            // If car2's mpg is greater than car1's mpg
            if(car1.mpg < car2.mpg) {
                return 1;
            }
        }
        // If car1's make and mpg is equal to car2's make and mpg
        return 0;
    }
}

/**
 * This class defines a car objects, with attributes such as make, model, and mpg
 */
class Car {
    public String make;
    public String model;
    public int mpg;

    /**
     * Constructor for a Car object which takes in a make, model, and mpg
     * @param make make of car
     * @param model model of car
     * @param mpg mpg of car
     */
    public Car(String make, String model, int mpg) {
        this.make = make;
        this.model = model;
        this.mpg = mpg;
    }
}

public class Homework3 {

    // Prints a car array
    public static void printCarArr(Car[] cars) {
        for(Car c:cars) {
            System.out.println(c.make + "\t" + c.model + "\t" + c.mpg);
        }
    }

    public static void main(String[] args) {
        // These are the comparators which are used when sorting
        CompareCarsByMakeThenModel compareCarsByMakeThenModel = new CompareCarsByMakeThenModel();
        CompareCarsByDescendingMPG compareCarsByDescendingMPG = new CompareCarsByDescendingMPG();
        CompareCarsByMakeThenDescendingMPG compareCarsByMakeThenDescendingMPG = new CompareCarsByMakeThenDescendingMPG();

        // Array of cars used for testing purposes to verify comparators and sorting
        Car cars[] = {
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

        /**
         * This block of code is used to show that the comparators do their job and quick sort sorts properly!!!
         */
        System.out.print("'CARS' ARRAY UNSORTED:\n\n");
        printCarArr(cars);
        System.out.print("\n\n'CARS' ARRAY SORTED BY MAKE THEN MODEL:\n\n");
        QuickSort.quickSort(cars, compareCarsByMakeThenModel);
        printCarArr(cars);
        System.out.print("\n\n'CARS' ARRAY SORTED BY DESCENDING MPG:\n\n");
        QuickSort.quickSort(cars, compareCarsByDescendingMPG);
        printCarArr(cars);
        System.out.print("\n\n'CARS' ARRAY SORTED BY MAKE THEN DESCENDING MPG:\n\n");
        QuickSort.quickSort(cars, compareCarsByMakeThenDescendingMPG);
        printCarArr(cars);
    }
}
