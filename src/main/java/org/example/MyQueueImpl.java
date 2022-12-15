package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueueImpl<T> implements MyQueue<T> {
    ArrayList<T> elements;


    public MyQueueImpl () {
        elements = new ArrayList<>();
     }


    @Override
    public void add(T el) {
        elements.add(el);
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        else {
            T el = elements.get(0);
            elements.remove(0);
            return el;
        }
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else return elements.get(0);
     }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0;
    }


    @Override
    public String toString() {
        return "{" +
                "QueueElements=" + elements +
                '}';
    }
}
