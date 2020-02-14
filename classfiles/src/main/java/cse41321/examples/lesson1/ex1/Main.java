//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex1;

public class Main {
    // args reference stored on stack, array object stored in heap
    public static void main(String[] args) {
        // references stored on stack, objects stored on heap
        Person sam = new Person("Sam", 12);
        Person rhonda = new Person("Rhonda", 12);

        // rhonda object still stored on heap, sam.friend refers to her
        sam.setFriend(rhonda);

        // tenYears primitive stored on stack
        int tenYears = 10;

        // temporary result of addition stored on stack
        sam.setAge(sam.getAge() + tenYears);
    }
}
