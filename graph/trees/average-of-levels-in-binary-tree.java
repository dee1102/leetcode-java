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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> averages = new ArrayList<>();

        queue.offer(root);
        while (queue.size() > 0) {
            int polls = 0;
            long sum = 0; // important as we need to consider interger overflow, check conditions. sum is more than INT_MAX in one case.
            int currentLevelNodes = queue.size();
            for (int i = 0; i < currentLevelNodes; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
                polls++;
            }
            averages.add((double) sum / polls);
        }
        return averages;
    }
}