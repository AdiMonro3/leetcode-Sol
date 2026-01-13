// Last updated: 13/01/2026, 10:14:08
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode oddEvenList(ListNode head) {
13        if (head == null || head.next == null) {
14            return head; 
15        }
16
17        ListNode odd = head;
18        ListNode even = head.next;
19        ListNode evenHead = even; 
20
21        while (even != null && even.next != null) {
22            odd.next = even.next; 
23            odd = odd.next;       
24
25            even.next = odd.next; 
26            even = even.next;     
27        }
28
29        odd.next = evenHead; 
30
31        return head;
32    }
33}