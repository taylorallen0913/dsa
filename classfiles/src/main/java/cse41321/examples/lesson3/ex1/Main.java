// Main.java
package cse41321.examples.lesson3.ex1;

// Outputs:
//     c5.compareTo(c150): -1
//     c150.compareTo(c5): 1
//     c5.compareTo(c5): 0
public class Main {
    public static void main(String[] args) {
        Circle c5 = new Circle(5);
        Circle c150 = new Circle(150);

        System.out.println("c5.compareTo(c150): " + c5.compareTo(c150));
        System.out.println("c150.compareTo(c5): " + c150.compareTo(c5));
        System.out.println("c5.compareTo(c5): " + c5.compareTo(c5));
    }
}
