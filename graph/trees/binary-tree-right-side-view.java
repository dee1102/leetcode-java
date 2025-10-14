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

// correct way
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        queue.offer(root);
        while (queue.size() > 0) {
            int rightMost = 0;
            int currentLevelNodes = queue.size();
            for (int i = 0; i < currentLevelNodes; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == currentLevelNodes - 1) {
                    rightMost = node.val;
                }
            }
            traversal.add(rightMost);
        }
        return traversal;
    }
}

// incorrect way
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rights = new ArrayList<>();

        if (root == null) {
            return rights;
        }

        List<Integer> leftA = new ArrayList<>();
        leftA.add(root.val);
        List<Integer> rightA = new ArrayList<>();
        rightA.add(root.val);

        if (root.left != null) {
            leftA.addAll(rightSideView(root.left));
        }
        if (root.right != null) {
            rightA.addAll(rightSideView(root.right));
        }
        rights = rightA;
        if (rightA.size() < leftA.size()) {
            System.out.println(leftA.size());
            System.out.println(rightA.size());

            rights.addAll(leftA.subList(rightA.size(), leftA.size()));
        }
        return rights;
    }
}