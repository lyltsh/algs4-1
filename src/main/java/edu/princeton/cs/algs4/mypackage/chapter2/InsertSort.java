package edu.princeton.cs.algs4.mypackage.chapter2;

public class InsertSort extends MySortExample {
    /**
     * 插入排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
