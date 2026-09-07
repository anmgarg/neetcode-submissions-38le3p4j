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
        List<TreeNode> pAncestors = getAncestors(root, p);
        List<TreeNode> qAncestors = getAncestors(root, q);

        for (TreeNode node: pAncestors) {
            if (qAncestors.contains(node)) {
                return node;
            }
        }
        return null;
    }

    List<TreeNode> getAncestors(TreeNode root, TreeNode target) {
        List<TreeNode> ancestors = new ArrayList<>();
        findTarget(root, target, ancestors);
        return ancestors;

    }

    boolean findTarget(TreeNode root, TreeNode target, List<TreeNode> ancestors) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            ancestors.add(root);
            return true;
        }
        if (target.val < root.val && findTarget(root.left, target, ancestors)) {
            ancestors.add(root);
            return true;
        } else if (target.val > root.val && findTarget(root.right, target, ancestors)) {
            ancestors.add(root);
            return true;
        } else {
            return false;
        }

    }
}
