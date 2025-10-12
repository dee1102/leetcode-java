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

// bad time complexity and space complexity
//    🔍 Problem: Time Limit Exceeded (TLE)
//Each recursive call does the following expensive operations:
//        Arrays.copyOfRange(...) — creates new subarrays at every recursion level (O(n) each time).
//findIndex(inorder, preorder[0]) — linear search per call (O(n)).
//Recursion happens n times, making the total complexity roughly O(n²) (and even higher because of array copying).
//For large inputs (like 1000+ nodes), that’s too slow.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        System.out.println("----");
        System.out.println(Arrays.toString(preorder));
        System.out.println(Arrays.toString(inorder));

        TreeNode node = new TreeNode();
        node.val = preorder[0];
        if (preorder.length == 1) {
            node.left = null;
            node.right = null;
        } else {
            int inorderIndex = findIndex(inorder, preorder[0]);
            System.out.println("inorderIndex " + inorderIndex);
            if (inorderIndex == -1) {
                // some mistake
            }
            int[] leftTree = Arrays.copyOfRange(inorder, 0, inorderIndex);
            System.out.println(Arrays.toString(leftTree));
            int[] rightTree = Arrays.copyOfRange(inorder, inorderIndex + 1, inorder.length);
            System.out.println(Arrays.toString(rightTree));
            if (leftTree.length == 0) {
                node.left = null;
            } else {
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, leftTree.length + 1), leftTree);
            }
            if (rightTree.length == 0) {
                node.right = null;
            } else {
                node.right = buildTree(Arrays.copyOfRange(preorder, leftTree.length + 1, preorder.length), rightTree);
            }
        }
        return node;
    }

    public static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the element is found
            }
        }
        return -1; // Return -1 if the element is not found
    }
}

// chatgpt - optimized
//class Solution {
//    private Map<Integer, Integer> inorderMap;
//    private int preorderIndex = 0;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        inorderMap = new HashMap<>();
//        // Store inorder value → index for O(1) lookup
//        for (int i = 0; i < inorder.length; i++) {
//            inorderMap.put(inorder[i], i);
//        }
//        return build(preorder, 0, inorder.length - 1);
//    }
//
//    private TreeNode build(int[] preorder, int inStart, int inEnd) {
//        // Base case
//        if (inStart > inEnd) return null;
//
//        // Root is the current preorder element
//        int rootVal = preorder[preorderIndex++];
//        TreeNode root = new TreeNode(rootVal);
//
//        // Find root index in inorder
//        int inIndex = inorderMap.get(rootVal);
//
//        // Build left and right subtrees using boundaries
//        root.left = build(preorder, inStart, inIndex - 1);
//        root.right = build(preorder, inIndex + 1, inEnd);
//
//        return root;
//    }
//}
