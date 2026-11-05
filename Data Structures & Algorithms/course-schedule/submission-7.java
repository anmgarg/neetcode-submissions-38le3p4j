class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> al = new HashMap<>();

        // construct adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            al.putIfAbsent(prerequisite[0], new ArrayList<>());
            al.get(prerequisite[0]).add(prerequisite[1]);
        }

        // construct & fill indegree array
        int[] indegree = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry: al.entrySet()) {      
            
            for (int neighbor: entry.getValue()) {
                indegree[neighbor]++;
            }
        }

        List<Integer> topSorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Fill queue with nodes whose indegree is 0;

        for (int i=0; i< indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topSorted.add(node);

            if(al.get(node) == null) {
                continue;
            }

            for(int neighbor: al.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return topSorted.size() == numCourses;
    }

}
