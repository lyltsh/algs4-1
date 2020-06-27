package edu.princeton.cs.algs4.mypackage.chapter2;

public class SelectionSort extends MySortExample {
    /**
     * 选择排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = findMin(a, i, a.length - 1);
            exch(a, i, minIndex);
        }
    }

    private static int findMin(Comparable[] a, int start, int end) {
        if (start < 0 || end > a.length - 1) {
            throw new IllegalArgumentException("out of index");
        }
        if (start > end) {
            throw new IllegalArgumentException("start is greater than end");
        }
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (less(a[i], a[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

}
