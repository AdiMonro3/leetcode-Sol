// Last updated: 28/05/2026, 01:23:39
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
12    public ListNode partition(ListNode head, int x) {
13        ListNode smallHead = new ListNode(0);
14        ListNode bigHead = new ListNode(0);
15
16        ListNode small = smallHead;
17        ListNode big = bigHead;
18
19        while (head != null) {
20
21            if (head.val < x) {
22                small.next = head;
23                small = small.next;
24            } else {
25                big.next = head;
26                big = big.next;
27            }
28
29            head = head.next;
30        }
31
32        // important to avoid cycle
33        big.next = null;
34
35        // connect both lists
36        small.next = bigHead.next;
37
38        return smallHead.next;
39    }
40}