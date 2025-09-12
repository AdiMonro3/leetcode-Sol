// Last updated: 13/09/2025, 01:51:00
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists. When one pointer reaches the end, move it to the head of the other list.
        // If there's an intersection, they'll meet at the intersection node.
        // If not, both will become null at the end (and exit loop).
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either the intersection node or null
        return a;
    }
}