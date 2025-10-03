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
// O(n) and O(n)
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = 0;
        int rightLength = 0;
        if (root.left != null) {
            leftLength = maxDepth(root.left);
        }
        if (root.right != null) {
            rightLength = maxDepth(root.right);
        }
        if (leftLength > rightLength) {
            return leftLength + 1;
        } else {
            return rightLength + 1;
        }
    }
}