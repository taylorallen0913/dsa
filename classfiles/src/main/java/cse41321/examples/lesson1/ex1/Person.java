// Person.java
package cse41321.examples.lesson1.ex1;

public class Person {
    // name primitive field stored in Person object
    private String name;

    // age primitive field stored in Person object
    private int age;

    // friend reference field stored in Person object,
    // the Person referred to will be stored on the heap
    private Person friend;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }
}
