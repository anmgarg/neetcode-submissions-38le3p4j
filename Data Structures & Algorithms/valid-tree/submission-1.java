class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();

        // construct and initialise the al
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] pair = new int[2];
        pair[0] = 0;
        pair[1] = -1;
        queue.offer(pair);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (visited.contains(node[0])) {
                //System.out.println("Returning false from inside queue");
                return false;
            }

            for (int neighbor : al.get(node[0])) {
                if (neighbor == node[1]) {
                    continue;
                }
                queue.offer(new int[]{neighbor, node[0]});
            }
            visited.add(node[0]);
            //System.out.println(queue);
            //System.out.println(visited);
        }

        if (visited.size() != n) {
            return false;
        }

        return true;
    }
}

// 0 - 1
// 1 - 0,2,3
// 2 - 1, 3
// 3 - 1, 2
// 4 - 1
