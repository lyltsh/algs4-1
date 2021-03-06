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
        //如果mid小于mid+1，那么就不需要合并了
        if (less(a[mid], a[mid + 1])) {
            return;
        }
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

    public static void main(String[] args) {
        Double[] a = new Double[10000];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }
        System.out.println("Before Sort");
//        show(a);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        assert isSorted(a);
        System.out.println("After Sort");
//        show(a);
        System.out.println("sort Duration: " + (end - start));
    }
}
