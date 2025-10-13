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
    boolean sub = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null) {
            if (root.val == targetSum) {
                return true;
            }
        }

        boolean leftBool = false;
        boolean rightBool = false;
        if (root.left != null) {
            leftBool = hasPathSum(root.left, targetSum - root.val); // 22 - 5 = 17 - 4 = 13 - 11 = 2
        }

        if (root.right != null) {
            rightBool = hasPathSum(root.right, targetSum - root.val);
        }

        return leftBool || rightBool;
    }
}