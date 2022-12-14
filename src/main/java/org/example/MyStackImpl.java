package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;

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
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Object el = elements.get(elements.size() - 1);
        elements.remove(elements.size() -1);
        return el;
    }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    @Override
    public String toString() {
        return "{" +
                "StackElements=" + elements +
                '}';
    }
}
