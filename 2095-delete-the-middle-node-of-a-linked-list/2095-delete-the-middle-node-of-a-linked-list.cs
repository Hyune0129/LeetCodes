/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode DeleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        ListNode mid = head;
        ListNode prev = head;
        ListNode ptr = head;
        while(ptr != null && ptr.next != null) {
            prev = mid;
            mid = mid.next;
            ptr = ptr.next.next;
        }
        prev.next = prev.next.next;
        
        return head;
    }
}