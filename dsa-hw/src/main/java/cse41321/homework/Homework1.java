package cse41321.homework;

import java.util.Random;

/**
 * CSE 41321 Homework #1
 * @author Taylor Allen
 * @version 1-20-20
 */
public class Homework1 {

    /**
     * Function to insert a number into a new array by copying a new array, alocating a new slot, and inserting
     * @param array Original array of integers
     * @param index Location where value will be inserted
     * @param value Value to be inserted
     * @return Old array with value inserted into it
     */

    // O(n)
    static int[] insert(int array[], int index, int value) {
        // Create new array one larger than original array
        int newArray[] = new int[array.length + 1]; // O(1)

        // Copy elements up to insert point from original array to new array
        for(int i = 0; i < index; i++) { // O(n)
            newArray[i] = array[i]; // O(1)
        }

        // Place insert value into new array
        newArray[index] = value; // O(n)

        // Copy elements after insert point from original array to new array
        for(int i = index; i < array.length; i++) { // O(n)
            newArray[i+1] = array[i]; // O(1)
        }

        return newArray; // O(1)
    }

    // O(n^3)
    public static void main(String[] args) {
        Random r = new Random(); // O(1)

        // Setting to allow fine-tuning the granularity of the readings
        final int NUM_READINGS = 60; // O(1)
        final int INSERTS_PER_READING = 10000; // O(1)
        final int NANO_SECONDS_PER_SECOND = 1000000000; // O(1)

        // Start with an array containing 1 element
        int[] array = {0}; // O(1)

        // Take NUM_READINGS readings
        for(int i = 0; i < NUM_READINGS; i++) { // O(n^3)
            // Each reading will be taken after INSERTS_PER_READING inserts
            double startTime = System.nanoTime(); // O(1)
            for(int x = 0; x < INSERTS_PER_READING; x++) { // O(n^2)
                int index = r.nextInt(array.length); // O(n)
                int value = r.nextInt(); // O(1)
                array = Homework1.insert(array, index, value); // O(n)
            }
            double stopTime = System.nanoTime(); // O(1)
            double timePerInsert = (stopTime - startTime) / INSERTS_PER_READING; // O(1)

            // Output reading in tabular format
            System.out.println("Array Length: " + (array.length - 1) + "\t\tSeconds Per Insert: " + timePerInsert / NANO_SECONDS_PER_SECOND); // O(1)
        }

    }

}
