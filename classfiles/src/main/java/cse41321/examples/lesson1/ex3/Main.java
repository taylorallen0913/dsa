//-------------------------------------------------------------------------
// Main.java
//-------------------------------------------------------------------------
package cse41321.examples.lesson1.ex3;
// Courtesy of: http://examples.javacodegeeks.com/core-java/util/arraylist/arraylist-in-java-example-how-to-use-arraylist/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creating an empty array list
        ArrayList<String> list = new ArrayList<String>();

        // Adding items to arrayList
        list.add("Item1");
        list.add("Item2");
        // it will add Item3 to the third position of array list
        list.add(2, "Item3");
        list.add("Item4");

        // Checking index of an item
        int pos = list.indexOf("Item2");

        // Checking if array list is empty
        boolean check = list.isEmpty();

        // Getting the size of the list
        int size = list.size();

        // Checking if an element is included to the list
        boolean element = list.contains("Item5");

        // Getting the element in a specific position
        String item = list.get(0);

        // Retrieve elements from the arraylist

        // 1st way: loop using index and size list
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index: " + i + " - Item: " + list.get(i));
        }

        // 2nd way:using foreach loop
        for (String str : list) {
            System.out.println("Item is: " + str);
        }

        // 3rd way:using iterator
        // hasNext(): returns true if there are more elements
        // next(): returns the next element
        System.out.println("Retrieving items using iterator");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            System.out.println("Item is: " + it.next());
        }

        // Replacing an element
        list.set(1, "NewItem");

        // Removing items

        // removing the item in index 0
        list.remove(0);

        // removing the first occurrence of item "Item3"
        list.remove("Item3");

        // Converting ArrayList to Array
        String[] simpleArray = list.toArray(new String[list.size()]);
    }
}
