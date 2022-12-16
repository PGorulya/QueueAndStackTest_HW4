package org.advanced;

//import java.util.Comparator;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T>{

    private static int DEFAULT_SIZE = 10;
    private static float DEFAULT_GROWTH_RATE = 2;
    private Object[] elements;
    private int pointer;
    private float growthRate;

    public MyStackImpl() {
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        growthRate = DEFAULT_GROWTH_RATE;
    }

    public MyStackImpl(float growthRate) {
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        this.growthRate = growthRate;
    }


    @Override
    public void push(T el) {
        if (needToGrow()) {
            grow();
        }
        elements[++pointer] = el;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T el = (T) elements[pointer];
        elements[pointer--] = null;
        return el;
    }

    private void grow() {
        int newLength = (int) (elements.length * growthRate);
        Object[] newElements = Arrays.copyOf(elements, newLength);
        elements = newElements;
    }

    private boolean needToGrow() {
        return pointer == elements.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return pointer < 0;
    }

    @Override
    public String toString() {
        return "{" +
                "StackElements=" + Arrays.toString(elements) +
                '}';
    }
}
