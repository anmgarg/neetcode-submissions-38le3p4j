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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);

        if (maxDepthLeft > maxDepthRight) {
            return count + maxDepthLeft;
        } else {
            return count + maxDepthRight;
        }
        
    }
}
