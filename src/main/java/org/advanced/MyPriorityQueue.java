package org.advanced;

public interface MyPriorityQueue<T> {

    void add(T el);

    T poll();

    T peek();

    boolean isEmpty();

}
