// Main.java
package cse41321.examples.lesson2.ex2;

import cse41321.containers.SinglyLinkedList;

/**
 * Program that merges two sorted lists of animals into one
 * sorted list then outputs the contents of the single list.
 *
 * Program output:
     List
     ----
     crocodile
     lizard
     snake
     turtle
     List
     ----
     finch
     owl
     parrot
     penguin
     List
     ----
     crocodile
     finch
     lizard
     owl
     parrot
     penguin
     snake
     turtle
 */
public class Main {
    public static void main(String[] args) {
        // List of sorted reptiles
        SinglyLinkedList<String> sortedReptiles =
                new SinglyLinkedList<String>();
        sortedReptiles.insertTail("crocodile");
        sortedReptiles.insertTail("lizard");
        sortedReptiles.insertTail("snake");
        sortedReptiles.insertTail("turtle");
        outputList(sortedReptiles);

        // List of sorted birds
        SinglyLinkedList<String> sortedBirds =
                new SinglyLinkedList<String>();
        sortedBirds.insertTail("finch");
        sortedBirds.insertTail("owl");
        sortedBirds.insertTail("parrot");
        sortedBirds.insertTail("penguin");
        outputList(sortedBirds);

        // List of sorted reptiles and birds merged together
        SinglyLinkedList<String> sortedAllAnimals =
                mergeLists(sortedReptiles, sortedBirds);
        outputList(sortedAllAnimals);
    }

    private static void outputList(SinglyLinkedList<String> list) {
        System.out.println("List");
        System.out.println("----");
        SinglyLinkedList<String>.Element elem = list.getHead();
        while (elem != null) {
            System.out.println("\t" + elem.getData());
            elem = elem.getNext();
        }
    }

    private static SinglyLinkedList<String> mergeLists(
            SinglyLinkedList<String> sortedList1,
            SinglyLinkedList<String> sortedList2) {
        SinglyLinkedList<String> merged = new SinglyLinkedList<String>();

        // Add all elements from both lists to the merged list while
        // maintaining sort order
        SinglyLinkedList<String>.Element elem1 = sortedList1.getHead();
        SinglyLinkedList<String>.Element elem2 = sortedList2.getHead();
        while (elem1 != null || elem2 != null) {
            String dataToInsert;

            // Determine which element should be added next
            if (elem1 == null) {
                // List 1 exhausted, next element from list 2 will be added
                dataToInsert = elem2.getData();
                elem2 = elem2.getNext();
            } else if (elem2 == null) {
                // List 2 exhausted, next element from list 1 will be added
                dataToInsert = elem1.getData();
                elem1 = elem1.getNext();
            } else {
                // List 1 & 2 contain more elements, determine which is smaller
                if (elem1.getData().compareTo(elem2.getData()) < 0) {
                    // List 1 element smaller, it will be added
                    dataToInsert = elem1.getData();
                    elem1 = elem1.getNext();
                } else {
                    // List 2 element smaller, it will be added
                    dataToInsert = elem2.getData();
                    elem2 = elem2.getNext();
                }
            }

            // Add element to merged list
            merged.insertTail(dataToInsert);
        }

        return merged;
    }
}