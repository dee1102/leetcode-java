/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode current = new ListNode(), head = current;

        while (l1 != null || l2 != null || carry != 0) {
            int ans = carry;
            if (l1 != null) {
                ans += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                ans += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(ans % 10);
            carry = ans / 10;
            if (head == null) {
                head = current;
            }
            current = current.next;
        }
        return head.next;
    }
}