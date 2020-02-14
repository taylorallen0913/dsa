// Main.java
package cse41321.examples.lesson1.ex10;

// Execute:  java Main Drink Hot Java
// Output:   Drink
//           Hot
//           Java
public class Main {
    public static void main (String[] args) {
        for (String s: args) {
            System.out.println(s);
        }
    }
}