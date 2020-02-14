//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex5;

public class Main {
    private int array[] = { /* Some number of elements */ };

    // O(n)
    private int compute1(int array[]) {                 // O(1)
        int val = 0;                                    // O(1)
        for (int i = 0; i < array.length; ++i) {        // O(n)
            val += i - 3;                               // O(1)
        }
        return val;                                     // O(1)
    }

    // O(n)
    private int compute2(int array[]) {                 // O(1)
        int val = 0;                                    // O(1)
        for (int i = array.length - 1; i >= 0; --i) {   // O(n)
            val += 2 * i;                               // O(1)
        }
        return val;                                     // O(1)
    }

    // O(n^2)
    private int compute3(int array[]) {                 // O(1)
        int val = 0;                                    // O(1)
        for (int i = 0; i < array.length; ++i) {        // O(n)
            for (int j = 0; j < array.length; ++j) {    // O(n)
                val += i;                               // O(1)
            }
        }
        return val;                                     // O(1)
    }

    public static void main(String[] args) {
    }
}
