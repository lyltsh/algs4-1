package edu.princeton.cs.algs4.mypackage.chapter2;

public class ShellSort extends MySortExample {
    /**
     * 希尔排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                //将a[i]插入到a[i-h], a[i-2h], a[i-3h]...之中
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
