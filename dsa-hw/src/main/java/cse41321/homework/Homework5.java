package cse41321.homework;

import java.util.Random;

public class Homework5 {
    /*
    I found this method online at https://www.baeldung.com/java-random-string.
    This method was not written by me (I partially modified it). I am using
    this method to randomly generate a string to insert into my hash table.
    */
    private static String randomAlphabeticalString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    // Generate a random integer from 0 to 1,000,000 (1 million)
    private static int randomInteger() {
        Random r = new Random();
        return r.nextInt(1000000);
    }

    public static void main(String[] args) {
        // Number of insertions
        final Integer NUM_ELEMENTS_TO_INSERT = 20;
        // Number of starting buckets in hash table
        int numBuckets = 5;
        // Max load factor of hash table
        double maxLoadFactor = 0.5;
        // Resize multiplier of hash table
        double resizeMultiplier = 2;
        // Create a new hash table with types integer and string for testing
        ChainedHashTable<Integer,String> c = new ChainedHashTable<>(numBuckets, maxLoadFactor,resizeMultiplier);
        // Repeat insertion for number of insertions specified
        for(int i = 0; i < NUM_ELEMENTS_TO_INSERT; i++) {
            // Insert a pair of a random integer as a key and a random string as a value
            c.insert(randomInteger(), randomAlphabeticalString());
            // Output various statistics
            System.out.println("Buckets: " + c.numBuckets + "\t\tElements: " + c.getSize() + "\t\tLF: " + (double)c.getSize() / c.numBuckets + "\t\tMax LF: " + maxLoadFactor + "\t\tResize Multiplier: " + resizeMultiplier);
        }

    }
}
