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

        Map<Node, Node> clones = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        clones.put(node, new Node(node.val));

        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (clones.get(neighbor) == null) {
                    clones.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                clones.get(current).neighbors.add(clones.get(neighbor));

            }
            
        }

        return clones.get(node);
    }
}