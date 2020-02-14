package cse41321.homework;

import cse41321.containers.Stack;

import java.util.Random;

public class Homework4 {

    /**
     * This algorithm adds two numbers through inserting each value into a stack, adding the
     * individual values, then outputting the sum to a result stack, and printing the resultant
     * stack
     * @param num1 first number
     * @param num2 second number
     */
    public static void addLargeNumbers(String num1, String num2) {
        Stack<Integer> firstNum = new Stack<Integer>();
        Stack<Integer> secondNum = new Stack<Integer>();
        Stack<Integer> result = new Stack<Integer>();
        // Holds number to push to stack
        int numberToPush = 0;
        // Push each digit individually to respective stack by place value
        for(int i = 0; i < num1.length(); i++) {
            firstNum.push(Integer.parseInt(Character.toString(num1.charAt(i))));
        }
        for(int x = 0; x < num2.length(); x++) {
            secondNum.push(Integer.parseInt(Character.toString(num2.charAt(x))));
        }
        // While at least one element has a next value
        while(!firstNum.isEmpty() || !secondNum.isEmpty()) {
            // The two if-statements below check each list individually to see if there is a value, and if so, adds that value to our placeholder
            if(!firstNum.isEmpty()) {
                numberToPush += firstNum.peek();
                firstNum.pop();
            }
            if(!secondNum.isEmpty()) {
                numberToPush += secondNum.peek();
                secondNum.pop();
            }
            // Get digit in ones place
            int onesPlace = numberToPush % 10;
            // Get digit in tens place; If no tens place, then this value is 0
            int tensPlace = (numberToPush / 10) % 10;
            // Sets remainder to whatever number is in the tens place
            numberToPush = tensPlace;
            // Pushes the ones place value to the result stack
            result.push(onesPlace);
        }
        /** I set the result size to a variable because if I set it inside the for loop
         *  it would not iterate through all of the elements because .pop() changes the
         *  size (I figured this out after 30 minutes of banging my head)
         */
        int resultSize = result.getSize();
        // Print result stack digit by digit
        for(int i = 0; i < resultSize; i++) {
            System.out.print(result.pop());
        }
        // Formatting
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Random r = new Random();
        final int NUM_TEST_CASES = 10;
        for(int i = 0; i < NUM_TEST_CASES; i++) {
            // Create two random longs which would overflow if they were integers
            long num1 = (long)Integer.MAX_VALUE + (Math.abs(r.nextInt()));
            long num2 = (long)Integer.MAX_VALUE + (Math.abs(r.nextInt()));
            // Print expected output
            System.out.println("Expected output: " + (num1 + num2));
            // Do addLargeNumbers operation
            addLargeNumbers(Long.toString(num1), Long.toString(num2));
            System.out.print("\n\n");
        }

    }

}
