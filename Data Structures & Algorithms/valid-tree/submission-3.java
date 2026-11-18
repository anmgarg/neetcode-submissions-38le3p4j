class DisjointSet {

    int[] parent;
    int[] size;
    int components;

    DisjointSet (int n) {
        components = n;
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findP(int node) {
        // System.out.println("node is " + node);
        // System.out.println("parent of node is " + parent[node]);
        if (node == parent[node]) {
            return node;
        } else {
            node = findP(parent[node]);
        }
        return node;
    }

    boolean unionBySize(int u, int v) {
        // System.out.println("u is " + u);
        // System.out.println("v is " + v);
        int pu = findP(u);
        int pv = findP(v);

        // System.out.println("parent of pu is " + pu);
        // System.out.println("parent of pv is " + pu);

        if (pu == pv) {
            return false;
        }

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] = size[pv] + size[pu];
        } else {
            parent[pv] = pu;
            size[pu] = size[pu] + size[pv];
        }
        components--;
        return true;
    }

}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge: edges) {
            if (!ds.unionBySize(edge[0], edge[1])) {
                // System.out.println("return false");
                // System.out.println(edge[0]);
                // System.out.println(edge[1]);
                return false;
            }
        }
        return ds.components == 1;
    }
}
