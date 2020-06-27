package edu.princeton.cs.algs4.mypackage.chapter2;

import java.util.Arrays;

public class MySortExample {
    public static void sort(Comparable[] a) {
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        Arrays.stream(a)
                .forEach(item -> System.out.println(item + " "));
    }

    public static void main(String[] args) {
        Double[] a = new Double[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
