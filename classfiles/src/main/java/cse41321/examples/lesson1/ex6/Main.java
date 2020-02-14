//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex6;

public class Main {
    public static void main(String[] args) {
        int array[] = { /* Some number of elements */ };
        compute(array);
    }

    public static int compute(int array[]) {                        // O(1)
        int val = 0;                                                // O(1)
        for (int i = 0; i < array.length; ++i) {                    // O(n)
            // Executes 0 times the first time through outer loop
            // Executes n times the last time through outer loop
            // Executes n/2 times on average
            // We drop the division by 2 and get O(n)
            for (int j = 0; j < i; ++j) {                           // O(n)
                // Like the previous loop, varies in number of
                // times it executes, but the overall number
                // of times will increase as n increases
                // so performance is O(n)
                for (int k = i; k < array.length * 3; ++k) {        // O(n)
                    val += k;                                       // O(1)
                }
            }
        }
        return val;                                                 // O(1)
    }
}
