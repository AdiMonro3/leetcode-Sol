// Last updated: 15/04/2026, 23:04:33
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
12    ListNode getKth(ListNode curr, int k) {
13        while (curr != null && k > 0) {
14            curr = curr.next;
15            k--;
16        }
17        return curr;
18    }
19    public ListNode reverseKGroup(ListNode head, int k) {
20        ListNode dummy = new ListNode(0);
21        dummy.next = head;
22
23        ListNode prevGroupEnd = dummy;
24
25        while (true) {
26
27            ListNode kth = getKth(prevGroupEnd, k);
28            if (kth == null) break;
29
30            ListNode nextGroupStart = kth.next;
31
32           
33            ListNode prev = nextGroupStart;
34            ListNode curr = prevGroupEnd.next;
35
36            while (curr != nextGroupStart) {
37                ListNode temp = curr.next;
38                curr.next = prev;
39                prev = curr;
40                curr = temp;
41            }
42
43           
44            ListNode temp = prevGroupEnd.next; // new end after reverse
45            prevGroupEnd.next = kth;
46            prevGroupEnd = temp;
47        }
48
49        return dummy.next;
50    }
51}