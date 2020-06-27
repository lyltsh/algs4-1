package edu.princeton.cs.algs4.mypackage.chapter2;

public class QuickSort extends MySortExample {
    /**
     * 快速排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Comparable[] a, int low, int high) {
        int mid = partition(a, low, high);
        quickSort(a, low, mid - 1);
        quickSort(a, mid + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        if (low >= high)
            return low;
        int i = low + 1;
        int j = high;
        Comparable target = a[low];
        while (true) {
            while (less(a[i++], target) && i < j) break;
            while (less(target, a[j--]) && j > i) break;
            exch(a, i, j);
            if (i >= j) {
                break;
            }
        }
        exch(a, low, i);
        return i;
    }
}
