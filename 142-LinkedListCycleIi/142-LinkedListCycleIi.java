// Last updated: 13/09/2025, 01:51:09
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map= new HashMap<>();
        ListNode temp=head;
        while (temp != null) {
            
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            } else {
               
                map.put(temp, 1);
                return temp;
            }
            temp = temp.next; 
        }
        
        return null; 
    
    }
}