package edu.princeton.cs.algs4.mypackage.chapter2;

public class HeapSort extends MySortExample {
    private Comparable[] pq;
    private int N;

    public static void sort(Comparable[] a) {
    }

    public void insert(Comparable v) {
        pq[++N] = v;
        swim(N);
    }

    public Comparable deleteMax() {
        Comparable max = pq[1];
        exch(pq, 1, N);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 节点上浮
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(pq[k / 2], pq[k])) {
            exch(pq, k / 2, k);
            k /= 2;
        }
    }

    /**
     * 节点下沉
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(pq[j], pq[j + 1])) {
                j++;
            }

            if (!less(pq[k], pq[j])) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Double[] a = new Double[10];
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
