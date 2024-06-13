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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(10000, head);
        ListNode prev2Ptr = dummyHead; // range 2 from ptr
        int prev = head.val;
        for(ListNode ptr = head.next; ptr != null; ptr = ptr.next) {
            if(prev == ptr.val) {
                System.out.println(prev);
                while(ptr.next != null && ptr.next.val == prev) ptr = ptr.next;

                prev2Ptr.next = ptr.next;
                ptr = ptr.next;
                if(ptr == null)
                    break;
                prev = ptr.val;
                continue;
            }
            prev2Ptr = prev2Ptr.next;
            prev = ptr.val;
        }
        return dummyHead.next;
    }

    
}