package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue<T> {

    List<T> elements;

    private Comparator<? super T> comparator;

    public MyPriorityQueueImpl() {
        this.elements = new ArrayList<>();
        this.comparator = null;
    }
     public MyPriorityQueueImpl (Comparator<? super T> comparator) {
        this.elements = new ArrayList<>();
        this.comparator = comparator;
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
            int idx = 0;
            for (int i = 0; i < elements.size(); i++) {
                if(comparator.compare(el, elements.get(i)) >= 0) {
                    el = elements.get(i);
                    idx = i;
                };
            }
            elements.remove(idx);
            return el;

        }
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        else {
            T el = elements.get(0);
            for (int i = 0; i < elements.size(); i++) {
                if(comparator.compare(el,elements.get(i)) >= 0) {
                    el = elements.get(i);
                };
            }
            return el;
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0 ;

    }

    @Override
    public String toString() {
        return "{" +
                "PriorityQueueElements=" + elements +
                '}';
    }
}
