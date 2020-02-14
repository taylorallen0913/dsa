//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex9;

public class Main {
    public static void main(String args[]) {
        // This box can hold anything
        Box box = new Box();
        box.set("hello");
        // box.set(1);                      // This would compile
        String phrase = (String)box.get();  // Must cast

        // This box can only hold strings
        GenericBox<String> gbox = new GenericBox<String>();
        gbox.set("world");
        // gbox.set(1);                     // This would not compile
        String phrase2 = gbox.get();        // No need to cast
    }
}
