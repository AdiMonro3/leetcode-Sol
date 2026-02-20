// Last updated: 20/02/2026, 14:34:33
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
12    public ListNode swapPairs(ListNode head) {
13         // 🔴 Edge case: empty or single node
14        if (head == null || head.next == null) return head;
15
16        // 🧱 Dummy node to simplify head swapping
17        ListNode dummy = new ListNode(0);
18        dummy.next = head;
19
20        // prev points to node before the pair
21        ListNode prev = dummy;
22
23        // Continue while we have at least two nodes
24        while (prev.next != null && prev.next.next != null) {
25
26            // 🟢 Identify the two nodes to swap
27            ListNode first = prev.next;        // a
28            ListNode second = prev.next.next;  // b
29
30            /*
31                Current:
32                prev → first → second → next
33
34                After swap:
35                prev → second → first → next
36            */
37
38            // 🔁 Perform the swap (careful order!)
39
40            first.next = second.next;  // a → next
41            second.next = first;       // b → a
42            prev.next = second;        // prev → b
43
44            // 🚶 Move prev to end of swapped pair
45            prev = first;
46        }
47
48        return dummy.next;
49    }
50}