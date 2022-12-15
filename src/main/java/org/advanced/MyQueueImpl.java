package org.advanced;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueueImpl<T> implements MyQueue<T> {

    private static int DEFAULT_SIZE = 10;
    private static float DEFAULT_GROWTH_RATE = 2;
    private Object[] elements;
    private int pointer;
    private float growthRate;

    public MyQueueImpl() {
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        growthRate = DEFAULT_GROWTH_RATE;
    }

    @Override
    public void add(T el) {
        if (needToGrow()) {
            grow();
        }
        elements[++pointer] = el;
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        else {
            T el = (T) elements[0];
            for (int j = 0; j < pointer; j++) {
                elements[j] = elements[j + 1];
            }
            elements[pointer--] = null;
            return el;
        }
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else return (T) elements[0];

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
                "QueueElements=" + Arrays.toString(elements) +
                '}';
    }
}
