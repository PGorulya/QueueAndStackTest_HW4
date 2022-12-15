package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T> {

    ArrayList<T> elements;

    public MyStackImpl () {
        elements = new ArrayList<>();
    }

    @Override
    public void push(T el) {
            elements.add(el);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T el = elements.get(elements.size() - 1);
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
