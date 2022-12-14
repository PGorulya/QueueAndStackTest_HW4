package org.example;

import java.util.ArrayList;

public class MyStackImpl<T> implements MyStack {

    ArrayList<Object> elements;

    public MyStackImpl () {
        elements = new ArrayList<>();
    }

    @Override
    public void push(Object el) {
            elements.add(el);
    }

    @Override
    public Object pop() {
        Object el = elements.get(elements.size() - 1);
        elements.remove(elements.size() -1);
        return el;
    }

    @Override
    public boolean isEmpty() {
        if (elements.size() != 0 )  return true;
        else return false;
    }

    @Override
    public String toString() {
        return "{" +
                "StackElements=" + elements +
                '}';
    }
}
