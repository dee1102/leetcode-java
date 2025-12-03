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

// not utilizing the bst property
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> subtractions = new ArrayList<>();

        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (subtractions.contains(node.val)) {
                return true;
            }
            subtractions.add(k - node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }
}