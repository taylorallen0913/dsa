package cse41321.homework.homework1;

import java.util.Random;

/**
 * Profiles time required to insert random values into random locations in an
 * array. Prints table showing size of array vs. time to insert.
 *
 * Program output:
 *       Array length	Seconds per insert
 *               5001	          0.000007
 *              10001	          0.000013
 *              15001	          0.000014
 *              20001	          0.000008
 *              25001	          0.000011
 *              30001	          0.000022
 *              35001	          0.000016
 *              40001	          0.000027
 *              45001	          0.000020
 *              50001	          0.000032
 *              55001	          0.000026
 *              60001	          0.000027
 *              65001	          0.000025
 *              70001	          0.000030
 *              75001	          0.000029
 *              80001	          0.000033
 *              85001	          0.000037
 *              90001	          0.000041
 *              95001	          0.000044
 *              100001	          0.000041
 *              105001	          0.000040
 *              110001	          0.000046
 *              115001	          0.000060
 *              120001	          0.000061
 *              125001	          0.000066
 *              130001	          0.000062
 *              135001	          0.000068
 *              140001	          0.000073
 *              145001	          0.000073
 *              150001	          0.000076
 *              155001	          0.000085
 *              160001	          0.000077
 *              165001	          0.000090
 *              170001	          0.000081
 *              175001	          0.000085
 *              180001	          0.000094
 *              185001	          0.000105
 *              190001	          0.000093
 *              195001	          0.000095
 *              200001	          0.000097
 *              205001	          0.000113
 *              210001	          0.000109
 *              215001	          0.000108
 *              220001	          0.000108
 *              225001	          0.000108
 *              230001	          0.000110
 *              235001	          0.000114
 *              240001	          0.000116
 *              245001	          0.000120
 *              250001	          0.000126
 *              255001	          0.000123
 *              260001	          0.000127
 *              265001	          0.000143
 *              270001	          0.000156
 *              275001	          0.000159
 *              280001	          0.000160
 *              285001	          0.000168
 *              290001	          0.000159
 *              295001	          0.000163
 *              300001	          0.000163
 */
public class Homework1 {
    private static final int NUM_READINGS = 60;
    private static final int INSERTS_PER_READING = 5000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        profileInserts();
    }

    /**
     * Insert random values into random locations in array printing table
     * showing average insert time when finished.
     */
    private static void profileInserts() {
        // Start with array containing 1 element
        int[] array = { 0 };

        // Output header
        System.out.println("Array length\tSeconds per insert");

        // Take NUM_READINGS readings
        for (int reading = 0; reading < NUM_READINGS; reading++) {

            // Snapshot time before performing inserts
            long startTime = System.currentTimeMillis();

            // Insert INSERTS_PER_READING times into array
            for (int insert = 0; insert < INSERTS_PER_READING; insert++) {
                array = insert(array,
                        random.nextInt(array.length),
                        random.nextInt());
            }

            // Snapshot time after performing inserts
            long stopTime = System.currentTimeMillis();

            // Output reading
            System.out.println(String.format("%12d\t%18f",
                    array.length,
                    (stopTime - startTime) / (1000. * INSERTS_PER_READING)));
        }
    }

    /**
     * Insert random value into random location in array.
     * @param array into which random value will be inserted
     * @param index at which random value will be inserted
     * @param value to be inserted
     * @return array containing original values and newly inserted value
     */
    private static int[] insert(int[] array, int index, int value) {
        // Create new array one larger than original array
        int[] newArray = new int[array.length + 1];                     // O(1)

        // Copy elements up to insert point from original array to new array
        for (int i = 0; i < index; i++) {                               // O(n)
            newArray[i] = array[i];                                     // O(1)
        }

        // Place insert value into new array
        newArray[index] = value;                                        // O(1)

        // Copy elements after insert point from original array to new array
        for (int i = index + 1; i < newArray.length; i++) {             // O(n)
            newArray[i] = array[i - 1];                                 // O(1)
        }

        return newArray;                                                // O(1)
    }
}
