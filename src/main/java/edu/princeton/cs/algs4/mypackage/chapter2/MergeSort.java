package edu.princeton.cs.algs4.mypackage.chapter2;

public class MergeSort extends MySortExample {

    //一次性定义存储空间
    //这种方式带来的问题：是否会存在线程安全的问题，多个线程同时调用排序算法.
    private static Comparable[] aux;

    /**
     * 归并排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        //一次性分配临时变量的存储空间
        aux = new Comparable[a.length];
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

        for (int k = low; k <= high; k++) {
            //将a数组的元素复制一份到aux之中
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
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

    public static void main(String[] args) {
        Double[] a = new Double[40];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }
        System.out.println("Before Sort");
        show(a);
        sort(a);
        assert isSorted(a);
        System.out.println("After Sort");
        show(a);
    }
}
