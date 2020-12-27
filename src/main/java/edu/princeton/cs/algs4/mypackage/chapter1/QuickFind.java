package edu.princeton.cs.algs4.mypackage.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    /**
     * 以整数，初始化N个触点
     *
     * @param n
     */
    public QuickFind(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number less than 0");
        }
        parent = new int[n];
        count = n;
        for (int index = 0; index < n; index++) {
            parent[index] = index;
        }
    }

    /**
     * 在p和q之间添加一条连接
     * 如果p和q不在一个连接中，那么就应该将p和q所在的联通分量合并
     * <p>
     * 分析：单次执行union的时间复杂度：O（N）
     * 对于一个较大的数据集，建立起联通网络。最终用来判断某些节点是否是联通的。则执行的时间是O(N)*O(N)=O(N^2)的时间复杂度
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        if (connected(p, q)) {
            //p和q在同一个连接，返回
            return;
        }
        // p和q不在同一个连接，将p和q所在的联通分量，进行合并
        for (int index = 0; index < parent.length; index++) {
            if (find(index) == find(q)) {
                //将q所在的联通分量，归并值p所在的联通分量
                parent[index] = find(p);
                count--;
            }
        }
    }

    /**
     * p所在连接的标识（0~N-1）
     * 时间复杂度O(1)
     * @param p
     * @return
     */
    public int find(int p) {
        validate(p);
        return parent[p];
    }

    /**
     * 判断p、q是否联通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 联通分量的数值
     *
     * @return
     */
    public int count() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFind quickFind = new QuickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickFind.connected(p, q)) {
                continue;
            }
            quickFind.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFind.count() + " components");
    }
}
