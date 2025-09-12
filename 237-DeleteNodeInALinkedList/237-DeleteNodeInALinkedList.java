// Last updated: 13/09/2025, 01:50:17
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to be deleted cannot be null or the last node.");
        }

        node.val = node.next.val;  
        node.next = node.next.next;  
    }
    }
