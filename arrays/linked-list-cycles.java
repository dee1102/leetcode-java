/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * } O(n) and O(n)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        List<ListNode> trackerArray = new ArrayList<>();
        ListNode node = head;
        if (head == null) {
            return false;
        }
        while (!trackerArray.contains(node)) {
            trackerArray.add(node);
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        if (node.next == null) {
            return false;
        }
        return true;
    }
}

// O(n) and O(1)