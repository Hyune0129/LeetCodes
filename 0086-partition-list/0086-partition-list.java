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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode lessPtr = lessHead;
        ListNode greaterPtr = greaterHead;
        ListNode temp;
        for(ListNode ptr = head; ptr != null; ptr = ptr.next) {
            if(ptr.val < x) {
                lessPtr.next = ptr;
                lessPtr = lessPtr.next;
            } else {
                greaterPtr.next = ptr;
                greaterPtr = greaterPtr.next;
            }
        }
        lessPtr.next = greaterHead.next;
        greaterPtr.next = null;
        return lessHead.next;
    }
}