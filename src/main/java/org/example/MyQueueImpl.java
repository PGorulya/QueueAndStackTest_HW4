package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueueImpl<T> implements MyQueue {
    ArrayList<Object> elements;


    public MyQueueImpl () {
        elements = new ArrayList<>();
     }


    @Override
    public void add(Object el) {
        elements.add(el);
    }

    @Override
    public Object poll() {
        if (isEmpty()) return null;
        else {
            Object el = elements.get(0);
            elements.remove(0);
            return el;
        }
    }

    @Override
    public Object element() {
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
