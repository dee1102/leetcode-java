/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.next = null;
            return root;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(1, root);
        root = subConnect(root, 2, map);
        return root;
    }

    public Node subConnect(Node root, int level, HashMap<Integer, Node> map) {
        if (root.right == null && root.left == null) {
            return root;
        }
        if (root.left != null) {
            root.left = subConnect(root.left, level + 1, map);
            if (!map.containsKey(level)) {
                map.put(level, root.left);
            } else {
                map.get(level).next = root.left;
                map.put(level, root.left);
            }
        }
        if (root.right != null) {
            root.right = subConnect(root.right, level + 1, map);
            if (!map.containsKey(level)) {
                map.put(level, root.right);
            } else {
                map.get(level).next = root.right;
                map.put(level, root.right);
            }
        }
        return root;
    }
}

// chatgpt
// /*
/// / Definition for a Node.
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//    public Node() {}
//    public Node(int _val) { val = _val; }
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
//*/
//
//class Solution {
//    public Node connect(Node root) {
//        if (root == null) return null;
//
//        Node curr = root;  // current level head
//        Node dummy = new Node(0); // dummy head for next level
//        Node prev = dummy;
//
//        while (curr != null) {
//            while (curr != null) {
//                if (curr.left != null) {
//                    prev.next = curr.left;
//                    prev = prev.next;
//                }
//                if (curr.right != null) {
//                    prev.next = curr.right;
//                    prev = prev.next;
//                }
//                curr = curr.next; // move horizontally in current level
//            }
//            // move to next level
//            curr = dummy.next;
//            dummy.next = null;
//            prev = dummy;
//        }
//        return root;
//    }
//}