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
        int[] arr = new int[3];
        arr[0] = k;
        countAndTraverse(root, arr);
        return arr[2];
    }

    public void countAndTraverse(TreeNode node, int[] arr) {
        if (node == null) {
            return;
        }
        countAndTraverse(node.left, arr);
        arr[1]++;
        if (arr[1] == arr[0]) {
            arr[2] = node.val;
            return;
        }
        countAndTraverse(node.right, arr);
    }
}
