// GenericBox.java
package cse41321.examples.lesson1.ex9;

public class GenericBox<T> {
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // T stands for "Type"
    private T t;
}
