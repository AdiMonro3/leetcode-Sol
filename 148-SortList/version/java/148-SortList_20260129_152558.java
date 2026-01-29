// Last updated: 29/01/2026, 15:25:58
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
12    public ListNode mergeSortedList(ListNode l1,ListNode l2){
13        ListNode dummy=new ListNode(0);
14        ListNode curr=dummy;
15
16        while(l1!=null && l2!=null){
17            if(l1.val<=l2.val){
18                curr.next=l1;
19                l1=l1.next;
20            }else{
21                curr.next=l2;
22                l2=l2.next;
23            }
24            curr=curr.next;
25        }
26        // Jo list bachi ho, attach kar do
27        if (l1 != null) curr.next = l1;
28        else curr.next = l2;
29
30        return dummy.next;
31    }
32    public ListNode middle(ListNode head){
33        ListNode slow=head;
34        ListNode fast=head.next;
35
36        while(fast!=null && fast.next!=null){
37            fast=fast.next.next;
38            slow=slow.next;
39        }
40        return slow;
41    }
42    public ListNode sortList(ListNode head) {
43        if (head == null || head.next == null)
44        return head;
45
46        // 1. Find middle
47        ListNode mid = middle(head);
48
49        // 2. Split list
50        ListNode h2 = mid.next;
51        mid.next = null;
52
53        // 3. Sort both halves
54        ListNode h1 = sortList(head);
55        h2 = sortList(h2);
56
57        // 4. Merge
58        return mergeSortedList(h1, h2);
59
60
61    }
62}