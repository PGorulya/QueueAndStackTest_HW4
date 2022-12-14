package org.example;

import java.util.Comparator;

public class QueueAndStackTest {
    public static void main(String[] args) {

        MyStackImpl<String> myStack = new MyStackImpl<>();
        myStack.push("aaa");
        myStack.push("bbb");
        myStack.push("ccc");
        myStack.push("ddd");
        myStack.push("eee");

        System.out.println("STACK=====================");
        while (myStack.isEmpty()) {
            System.out.println(myStack);
            System.out.println("Output: " + myStack.pop());
        }

        MyQueueImpl<String> myQueue = new MyQueueImpl<>();
        myQueue.add("aaa");
        myQueue.add("bbb");
        myQueue.add("ccc");
        myQueue.add("ddd");
        myQueue.add("eee");

        System.out.println("QUEUE========================");
        System.out.println("Peek of Queue: " + myQueue.element());
        while (myQueue.isEmpty()) {
            System.out.println(myQueue);
            System.out.println("Output: " + myQueue.poll());
        }


        MyPriorityQueueImpl<String> myPrQueue = new MyPriorityQueueImpl<>(new Comparator<String>() {
             @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        myPrQueue.add("cab");
        myPrQueue.add("abc");
        myPrQueue.add("bca");
        myPrQueue.add("bac");
        myPrQueue.add("acb");

        System.out.println("PRIORITY QUEUE========================");
        System.out.println(myPrQueue);
        System.out.println("Peek of Priority Queue: " + myPrQueue.peek());
        while (myPrQueue.isEmpty()) {
            System.out.println(myPrQueue);
            System.out.println("Peek of Priority Queue: " + myPrQueue.poll());
        }
    }
}
