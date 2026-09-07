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
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }

        return result;
    }

    
}
