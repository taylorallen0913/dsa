//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex8;

public class Main {
    public static void doSomeLengthyOperation()
    {
        int i;
        for (i = 0; i < 1000; ++i)
            try
            {
                Thread.sleep(1); // Sleep for 1 millisecond
            }
            catch (Exception ex)
            {
            }
    }

    // Outputs:  Operation took 1.002278698 seconds.
    public static void main(String args[]) {
        final double NANO_SECONDS_PER_SECOND = 1000000000;

        long start = System.nanoTime();
        doSomeLengthyOperation();
        long stop = System.nanoTime();

        double duration = (double)(stop - start) / NANO_SECONDS_PER_SECOND;

        System.out.println("Operation took " + duration + " seconds.");
    }
}
