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