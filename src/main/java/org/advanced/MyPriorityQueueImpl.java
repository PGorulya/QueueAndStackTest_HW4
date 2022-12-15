package org.advanced;

import java.util.Arrays;
import java.util.Comparator;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue<T> {

    private static int DEFAULT_SIZE = 10;
    private static float DEFAULT_GROWTH_RATE = 2;
    private Object[] elements;
    private int pointer;
    private float growthRate;
    private Comparator<T> comparator;

    public MyPriorityQueueImpl() {
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        growthRate = DEFAULT_GROWTH_RATE;
    }

    public MyPriorityQueueImpl(Comparator<T> comparator) {
        super();
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        growthRate = DEFAULT_GROWTH_RATE;
        this.comparator = comparator;
    }

    public MyPriorityQueueImpl(float growthRate,Comparator<T> comparator) {
        elements = new Object[DEFAULT_SIZE];
        pointer = -1;
        this.growthRate = growthRate;
        this.comparator = comparator;
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
            int k = 0;
            for (int i = 0; i <= pointer; i++) {
                if (comparator.compare(el, (T) elements[i]) >= 0) {
                    el = (T) elements[i];
                    k = i;
                }
            }
            for (int j = k; j < pointer; j++) {
                elements[j] = elements[j + 1];
            }
            elements[pointer--] = null;
            return el;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        else {
            T el = (T) elements[0];
            for (int i = 0; i <= pointer; i++) {
                if (comparator.compare(el, (T) elements[i]) >= 0) {
                    el = (T) elements[i];
                }
            }
            return el;
        }
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
                "PrQueueElements=" + Arrays.toString(elements) +
                '}';
    }
}
