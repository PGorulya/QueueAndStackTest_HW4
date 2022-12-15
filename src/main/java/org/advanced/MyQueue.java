package org.advanced;

public interface MyQueue<T> {

    void add(T el);

    T poll();

    T element();

    boolean isEmpty();

}
