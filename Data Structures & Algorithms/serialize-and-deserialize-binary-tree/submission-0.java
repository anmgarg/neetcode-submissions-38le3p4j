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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder result = new StringBuilder("");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                result.append(node.val);
                result.append(",");
                q.offer(node.left);
                q.offer(node.right);
            } else {
                result.append("null");
                result.append(",");
            }
        }
        //System.out.println(result.toString());
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(list[0])) ;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            String left = list[count];
            String right = list[count+1];
            if(!"null".equals(left)) {
                node.left = new TreeNode(Integer.valueOf(left));
                q.offer(node.left);
            }
            if(!"null".equals(right)) {
                node.right = new TreeNode(Integer.valueOf(right));
                q.offer(node.right);
            }
            count = count + 2;
        }
        return root;
    }
}
