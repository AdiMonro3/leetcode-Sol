// Last updated: 14/06/2026, 19:46:05
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
12    public int pairSum(ListNode head) {
13
14        ListNode slow = head;
15        ListNode fast = head;
16
17        while(fast != null && fast.next != null){
18            slow = slow.next;
19            fast = fast.next.next;
20        }
21
22        ListNode prev = null;
23        ListNode curr = slow;
24
25        while(curr != null){
26            ListNode next = curr.next;
27            curr.next = prev;
28            prev = curr;
29            curr = next;
30        }
31
32        int maxSum = 0;
33
34        ListNode first = head;
35        ListNode second = prev;
36
37        while(second != null){
38            maxSum = Math.max(maxSum,
39                              first.val + second.val);
40
41            first = first.next;
42            second = second.next;
43        }
44
45        return maxSum;
46    }
47}