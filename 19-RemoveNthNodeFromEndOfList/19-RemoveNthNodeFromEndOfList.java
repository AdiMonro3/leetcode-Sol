// Last updated: 13/09/2025, 01:52:29
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int i = 0;
        
        // Move fast pointer n steps ahead
        while (i < n) {
            fast = fast.next;
            i++;
        }
        
        // Special case: if fast is null, that means the head is the node to remove
        if (fast == null) {
            return head.next;
        }

        ListNode slow = head;
        
        // Move both fast and slow pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Now, slow is just before the node to delete
        slow.next = slow.next.next;  // Remove the nth node from the end
        
        return head;
    }
}