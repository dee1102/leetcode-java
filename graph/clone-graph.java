/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Node[] visited = new Node[100];

        // Clone the root node first
        visited[node.val - 1] = new Node(node.val);

        while (!queue.isEmpty()) {
            Node cn = queue.poll();

            for (Node n: cn.neighbors) {
                // If this neighbor hasn't been cloned yet
                if (visited[n.val - 1] == null) {
                    visited[n.val - 1] = new Node(n.val, new ArrayList<>());
                    queue.offer(n);
                }

                // Add the cloned neighbor to the cloned current node
                visited[cn.val - 1].neighbors.add(visited[n.val - 1]);
            }
        }
        return visited[node.val - 1];
    }
}