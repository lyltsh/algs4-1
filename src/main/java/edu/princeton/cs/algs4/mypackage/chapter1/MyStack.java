package edu.princeton.cs.algs4.mypackage.chapter1;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private Node head;
    private int N = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T item) {
        Node oldFirst = head;
        head = new Node();
        head.t = item;
        head.next = oldFirst;
        N++;
    }

    public T pop() {
        if (head == null) {
            throw new IllegalStateException("stack is empty!");
        }
        Node oldFirst = head;
        head = oldFirst.next;
        N--;
        return oldFirst.t;
    }

    public T delete(int k) {
        if (k <= 0 || k > N) {
            throw new IllegalArgumentException("deleted index should be greater than 0. while the input index is" + k);
        }
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == k) {
                return temp.t;
            }
        }
        throw new IllegalArgumentException("can not find the index value");
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * 链表反转
     */
    public void reverse() {
        Node first = head;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        head = reverse;
    }

    /**
     * 递归方式实现链表反转
     */
    public Node reverse_recursive(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node rest = reverse_recursive(first.next);
        rest.next = first;
        first.next = null;
        return rest;
    }

    private class Node {
        private T t;
        private Node next;
    }
}
