package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue {

    List<Object> elements;

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
    public void add(Object el) {
        elements.add(el);
    }

    @Override
    public Object poll() {
        if (isEmpty()) return null;
        else {
            T res = (T) elements.get(0);
            int idx = 0;
            for (int i = 0; i < elements.size(); i++) {
                if(comparator.compare(res,(T)elements.get(i)) >= 0) {
                    res = (T)elements.get(i);
                    idx = i;
                };
            }
            elements.remove(idx);
            return res;

        }
    }

    @Override
    public Object peek() {
        if (isEmpty()) return null;
        else {
            T res = (T) elements.get(0);
            for (int i = 0; i < elements.size(); i++) {
                if(comparator.compare(res,(T)elements.get(i)) >= 0) {
                    res = (T)elements.get(i);
                };
            }
            return res;
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
