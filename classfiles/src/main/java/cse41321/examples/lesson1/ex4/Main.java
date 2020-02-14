//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex4;

public class Main {
    private int array[] = { /* Some number of elements */ };

    // Overall cost:  c1 + c2 + n*c3 + c4 + c5
    private int compute1(int array[]) {                 // c1
        int val = 0;                                    // c2
        for (int i = 0; i < array.length; ++i) {        // n * c3
            val += i - 3;                               // c4
        }
        return val;                                     // c5
    }

    // Overall cost:  c6 + c7 + n*c8 + c9 + c10
    private int compute2(int array[]) {                 // c6
        int val = 0;                                    // c7
        for (int i = array.length - 1; i >= 0; --i) {   // n * c8
            val += 2 * i;                               // c9
        }
        return val;                                     // c10
    }

    // Overall cost:  c11 + c12 + n*c13 + n*(n*c14) + c15 + c16
    private int compute3(int array[]) {                 // c11
        int val = 0;                                    // c12
        for (int i = 0; i < array.length; ++i) {        // n * c13
            for (int j = 0; j < array.length; ++j) {    // n * c14
                val += i;                               // c15
            }
        }
        return val;                                     // c16
    }

    public static void main(String[] args) {
    }
}
