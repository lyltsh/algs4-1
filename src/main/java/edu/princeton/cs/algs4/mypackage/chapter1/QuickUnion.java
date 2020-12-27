package edu.princeton.cs.algs4.mypackage.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    private final int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    /**
     * 以整数，初始化N个触点
     *
     * @param n
     */
    public QuickUnion(int n) {
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
     * 我们由p和q的链接分别找到它们的根触点，然后只需将一个根触点链接到另一个即可将一个分量重命名为另一个分量，因此这个算法叫做quick-union
     * 使用根触点的方式，判断两个节点所在的根节点是否相同，如果相同，那么属于相同的节点
     * 如果不相同，那么就将两者的根节点，修改成相同的数值即可
     * <p>
     * 时间复杂度：2*O(find)+1 = log(N)
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
        parent[find(q)] = find(p);
        count--;
    }

    /**
     * 找到分量的名称
     * 时间复杂度log(N)
     *
     * @param p
     * @return
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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
        QuickUnion uf = new QuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
