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
//Time Complexity: O(n)
//Space Complexity: O(h) (O(log n) balanced, O(n) skewed)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isLeftSame = false, isRightSame = false;
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null )) {
            return false;
        }
        if (p.left == null && p.right == null) {
            isLeftSame = q.left == null && q.right == null;
            isRightSame = q.left == null && q.right == null;
        }
        if (p.left != null) {
            isLeftSame = q.left != null && isSameTree(p.left, q.left);
        } else {
            isLeftSame = q.left == null;
        }
        if (p.right != null) {
            isRightSame = q.right != null && isSameTree(p.right, q.right);
        } else {
            isRightSame = q.right == null;
        }
        return p.val == q.val && isLeftSame && isRightSame;
    }
}