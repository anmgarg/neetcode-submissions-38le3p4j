class DisjointSet {

    int[] parent;
    int[] size;
    int components;

    DisjointSet (int n) {
        components = n;
        parent = new int[n];
        size = new int[n];

        for(int i =0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findP(int node) {
        if (node == parent[node]) {
            return node;
        } else {
            node = findP(parent[node]);
        }
        return node;
    }

    boolean unionBySize(int u, int v) {
        int pu = findP(u);
        int pv = findP(v);

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
    public int countComponents(int n, int[][] edges) {

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge: edges) {
            ds.unionBySize(edge[0], edge[1]);
        }

        return ds.components;

    }
}
