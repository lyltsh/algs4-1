package edu.princeton.cs.algs4.mypackage.chapter2;

import com.sun.tools.javac.util.Assert;

public class QuickSort extends MySortExample {
    /**
     * 快速排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 先找出中间数据的坐标，再分成两个子数组，进行排序
     * 小于mid索引的值，都小于等于mid索引的值
     * 大于mid索引的值，都大于等于mid索引的值
     */
    private static void quickSort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        //将数组切分成两个部分
        int mid = partition(a, low, high);
        //对数组左半部分进行排序
        quickSort(a, low, mid - 1);
        //对数组右半部分进行排序
        quickSort(a, mid + 1, high);
    }

    /**
     * 查找的过程中，进行交换
     * 小于start值的数据，左移
     * 大于start值的数据，右移
     */
    private static int partition(Comparable[] a, int low, int high) {
        if (low >= high) {
            return low;
        }
        Comparable start = a[low];
        int i = low + 1, j = high;
        while (true) {
            while (less(a[i], start) && i < high) {
                i++;
            }
            while (less(start, a[j]) && j > low) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    public static void main(String[] args) {
        Double[] a = new Double[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }
        System.out.println("Before Sort");
//        show(a);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println("After Sort");
//        show(a);
        Assert.check(isSorted(a));
        System.out.println("sort Duration: " + (end - start));
    }
}
