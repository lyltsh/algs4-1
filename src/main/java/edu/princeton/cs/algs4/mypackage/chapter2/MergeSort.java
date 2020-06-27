package edu.princeton.cs.algs4.mypackage.chapter2;


public class MergeSort extends MySortExample {
    /**
     * 归并排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        Comparable[] temp = new Comparable[high - low + 1];
        for (int k = low; k <= high; k++) {
            temp[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                temp[k] = a[j++];
            }
            if (j > high) {
                temp[k] = a[i++];
            }
            if (less(a[i], a[j])) {
                temp[k] = a[i++];
            } else if (less(a[j], a[i])) {
                temp[k] = a[j++];
            }
        }
        //赋值回原数组之中
        for (int k = low; k <= high; k++) {
            a[k] = temp[k];
        }
    }

    /**
     * 使用迭代方式实现归并排序
     *
     * @param a
     * @param low
     * @param high
     */
    private static void mergeSort_Iterate(Comparable[] a, int low, int high) {
        for (int sz = 1; sz < a.length; sz += sz) {
            //进行lgN次两两归并
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                //子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }
}
