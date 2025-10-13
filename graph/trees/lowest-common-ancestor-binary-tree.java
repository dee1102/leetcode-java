// second attempt - accepted - 50th percentile both
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = null;
        TreeNode right = null;
        TreeNode ancestor = null;

        // left recursive
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }

        // right recursive
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        if ((left == p || right == p || root == p) && (left == q || right == q || root == q) ) {
            ancestor = root;
        } else if (left != null) {
            ancestor = left;
        } else if (right != null) {
            ancestor = right;
        } else if (root == p || root == q) {
            ancestor = root;
        }

        return ancestor;
    }
}

// first attempt - accepted - bad complexities

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution {
//    TreeNode gp = null;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<Integer> a1 = new ArrayList<>();
//        List<Integer> a2 = new ArrayList<>();
//
//        treeParsing(root, p, q);
//
//        return gp;
//    }
//
//    public HashMap<String, Boolean> treeParsing(TreeNode root, TreeNode p, TreeNode q) {
//        HashMap<String, Boolean> found = new HashMap<String, Boolean>();
//
//        // check if gp is still null, means there is no need to process anything anymore
//        if (this.gp != null) {
//            return found;
//        }
//
//        HashMap<String, Boolean> lFound = null;
//        HashMap<String, Boolean> rFound = null;
//        boolean cFoundP = false;
//        boolean cFoundQ = false;
//
//
//        // current node
//        if (root.val == p.val) {
//            cFoundP = true;
//        }
//
//        if (root.val == q.val) {
//            cFoundQ = true;
//        }
//
//        // base case
//        if (root.left == null && root.right == null) {
//            found.put("p", cFoundP);
//            found.put("q", cFoundQ);
//        }
//
//        // left recursive
//        if (root.left != null) {
//            lFound = treeParsing(root.left, p, q);
//        }
//
//        // right recursive
//        if (root.right != null) {
//            rFound = treeParsing(root.right, p, q);
//        }
//
//        boolean foundP = (lFound != null && lFound.containsKey("p") && lFound.get("p")) || (rFound != null && rFound.containsKey("p") && rFound.get("p")) || cFoundP;
//        boolean foundQ = (lFound != null && lFound.containsKey("q") &&  lFound.get("q")) || (rFound != null && rFound.containsKey("q") && rFound.get("q")) || cFoundQ;
//
//        found.put("p", foundP);
//        found.put("q", foundQ);
//
//        if (foundP == true && foundQ == true && this.gp == null) {
//            this.gp = root;
//        }
//
//        return found;
//    }
//}