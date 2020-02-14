//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex7;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int array[] = { /* Some number of elements */ };
        Arrays.sort(array);
        binarySearch(array, 7);
    }

    public static int binarySearch(int array[], int value) {    // O(ln n)
        int lo = 0;                                             // O(1)
        int hi = array.length - 1;                              // O(1)
        while (lo <= hi) {                                      // O(ln n)
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;                       // O(1)
            if (value < array[mid]) {                           // O(1)
                hi = mid - 1;                                   // O(1)
            }
            else if (value > array[mid]) {                      // O(1)
                lo = mid + 1;                                   // O(1)
            }
            else return mid;                                    // O(1)
        }
        return -1;                                              // O(1)
    }
}
