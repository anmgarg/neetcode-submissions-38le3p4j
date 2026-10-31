/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            adjacencyList.putIfAbsent(temp.val, new ArrayList<>());
            
            for (Node neighbor : temp.neighbors) {
                adjacencyList.get(temp.val).add(neighbor.val);
                if (adjacencyList.get(neighbor.val) == null) {
                    adjacencyList.put(neighbor.val, new ArrayList<>());
                    queue.add(neighbor);
                }
            }
        }

        Map<Integer, Node> store = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry: adjacencyList.entrySet()) {
            store.putIfAbsent(entry.getKey(), new Node(entry.getKey()));
            Node temp = store.get(entry.getKey());
            temp.neighbors = new ArrayList<>();
            for (Integer val : entry.getValue()) {
                store.putIfAbsent(val, new Node(val));
                temp.neighbors.add(store.get(val));
            } 
        }

        return store.get(node.val);
    }
}