// Last updated: 28/01/2026, 13:18:15
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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode t1=l1;
14        ListNode t2=l2;
15
16        ListNode dummy=new ListNode(-1);
17        ListNode curr=dummy;
18        int carry=0;
19        while(t1!=null || t2!=null){
20            int v1=0;
21            int v2=0;
22            if(t1!=null){
23                v1=t1.val;
24                t1=t1.next;
25            }
26            if(t2!=null){
27                v2=t2.val;
28                t2=t2.next;
29            }
30
31            int sum=carry+v1+v2;
32            int digit=sum%10;
33            carry=sum/10;
34
35            ListNode n=new ListNode(digit);
36            curr.next=n;
37            curr=n;
38        }
39         if (carry > 0) {
40            curr.next = new ListNode(carry);
41        }
42        return dummy.next;
43        
44    }
45}