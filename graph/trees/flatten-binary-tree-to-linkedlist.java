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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            flatten(root.right);
        }

        if (root.left != null) {
            flatten(root.left);
            if (root.left != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode n = findRightLeaf(root.right);
                n.right = temp;
            }
        }
    }

    public TreeNode findRightLeaf(TreeNode root) {
        TreeNode node = null;
        if (root.right == null) {
            node = root;
        } else {
            node = findRightLeaf(root.right);
        }
        return node;
    }
}

// chatgpt
//class Solution {
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//
//            if (curr.right != null) stack.push(curr.right);
//            if (curr.left != null) stack.push(curr.left);
//
//            if (!stack.isEmpty()) {
//                curr.right = stack.peek();
//            }
//            curr.left = null;
//        }
//    }
//}
