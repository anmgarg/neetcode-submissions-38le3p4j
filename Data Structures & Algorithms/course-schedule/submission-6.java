class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> al = new HashMap<>();

        // construct adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            al.putIfAbsent(prerequisite[0], new ArrayList<>());
            al.get(prerequisite[0]).add(prerequisite[1]);
        }

        //System.out.println(al);
        HashSet<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry: al.entrySet()) {      
            HashSet<Integer> path = new HashSet<>();
            if (!dfs(entry.getKey(), al, visited,path)) {
                // System.out.println(visited);
                return false;
            }
            //System.out.println("passed");
        }
        return true;
    }

    boolean dfs(Integer toBeVisited, HashMap<Integer, List<Integer>> al, HashSet<Integer> visited, HashSet<Integer> path) {
        //System.out.println(toBeVisited);
        if (!path.add(toBeVisited)) {
            return false;
        }
        if (visited.contains(toBeVisited)) {
            return true;
        }
        List<Integer> neighbors = al.get(toBeVisited);
        if (neighbors == null) {
            path.remove(toBeVisited);
            visited.add(toBeVisited);
            return true;
        }
        for (Integer neighbor : neighbors) {
            boolean result = dfs(neighbor, al, visited, path);
            if(!result) {
                return false;
            }
        }
        path.remove(toBeVisited);
        visited.add(toBeVisited);
        return true;
    }
}
