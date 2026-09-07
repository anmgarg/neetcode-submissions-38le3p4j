/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, 1, map);
        return map.values().stream().toList();
    }

    void traverse(TreeNode root, int level, HashMap<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(level, new ArrayList<Integer>());
        list.add(root.val);
        map.put(level, list);
        level++;
        traverse(root.left, level, map);
        traverse(root.right, level, map);
    }
}
