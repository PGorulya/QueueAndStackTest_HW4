package org.example;

import java.util.ArrayList;

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
        if (elements.size() == 0) return null;
        else {
            Object el = elements.get(0);
            elements.remove(0);
            return el;
        }
    }

    @Override
    public Object element() {
        if (elements.size() == 0) return null;
        else return elements.get(0);
     }

    @Override
    public boolean isEmpty() {
        if (elements.size() != 0 )  return true;
        else return false;
    }


    @Override
    public String toString() {
        return "{" +
                "QueueElements=" + elements +
                '}';
    }
}
