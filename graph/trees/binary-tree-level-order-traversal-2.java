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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        queue.offer(root);
        while (queue.size() > 0) {
            List<Integer> currentLevel = new ArrayList<>();
            int currentLevelNodes = queue.size();

            for (int i = 0; i < currentLevelNodes; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                currentLevel.add(node.val);
            }
            traversal.add(currentLevel);
        }
        Collections.reverse(traversal);
        return traversal;
    }
}