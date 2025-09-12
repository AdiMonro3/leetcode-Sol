// Last updated: 13/09/2025, 01:50:22
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static int[] arr = new int[100000];
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode curr = head;
        int i=0;
        while(curr !=null) {
            arr[i++] = curr.val;
            curr = curr.next;
        }

       int left = 0,right=i-1;

       for(;left<=right;){
        if(arr[left++] != arr[right--]) return false;
       }

       return true;

       
    }
}