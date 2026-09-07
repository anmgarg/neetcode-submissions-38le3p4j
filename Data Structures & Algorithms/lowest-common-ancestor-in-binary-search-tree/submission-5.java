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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        while(null != current) {
            if (Math.max(p.val, q.val) < current.val) {
                current = current.left;
            } else if (Math.min(p.val, q.val) > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;    
    }
}
