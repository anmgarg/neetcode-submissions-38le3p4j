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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list.get(k-1).val;
    }

    public void inOrderTraversal(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node);
        inOrderTraversal(node.right, list);
    }
}
