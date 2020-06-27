package edu.princeton.cs.algs4.mypackage.chapter1;

public class MyQueue<T> {

    private Node head;
    private Node tail;
    private int length = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T item) {
        Node oldTail = tail;
        tail = new Node();
        tail.t = item;
        tail.next = oldTail;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        length++;
    }

    public T dequeue() {
        if (length <= 0 || head == null) {
            throw new IllegalStateException("queue is empty");
        }
        Node oldHead = head;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        length--;
        return oldHead.t;
    }

    public int size() {
        return length;
    }

    private class Node {
        private T t;
        private Node next;
    }
}
