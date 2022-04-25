package me.lukeoltmanns.calfmanager;

public class CounterStore {
    //Local Variable
    int counter;

    // Constructor
    public CounterStore() {
        this.counter = getCounter();
    }

    // Getter
    public int getCounter() {
        return counter;
    }

    // Setter
    public void setCounter(int counter) {
        this.counter = counter;
    }

    // toString
    @Override
    public String toString() {
        return "CounterStore{" +
                "counter=" + counter +
                '}';
    }
}
