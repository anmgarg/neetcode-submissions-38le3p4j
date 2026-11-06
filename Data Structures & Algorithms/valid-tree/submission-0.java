class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        
        List<List<Integer>> al = new ArrayList<>();

        // construct and initialise the al
        for (int i = 0; i<n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> path = new HashSet<>();
        
        
        boolean result = dfs(-1, 0, al, path);
        if (!result) {
            return false;
        }
        if (path.size() != n) {
            return false;
        }

        return true;
    }

    boolean dfs(int prevNode, int node, List<List<Integer>> al, Set<Integer> path) {
        if(!path.add(node)) {
            return false;
        }
        for(int neighbor: al.get(node)) {
            if (neighbor == prevNode) {
                continue;
            }
            boolean result = dfs(node, neighbor, al, path);
            if(!result) {
                return result;
            }
        }
        return true;
    }
}


// 0 - 1,2,3
// 1 - 0,4
// 2 - 0
// 3 - 0


// 0 - 1
// 1 - 0,2,3
// 2 - 1, 3
// 3 - 1, 2
// 4 - 1
