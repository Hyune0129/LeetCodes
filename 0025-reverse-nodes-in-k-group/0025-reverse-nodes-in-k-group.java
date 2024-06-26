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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode next;
        ListNode ptr = head;
        ListNode prev = dummyHead;
        while(hasNextK(ptr, k)) {
            prev.next = reverseGroup(ptr, k);
            prev = ptr;
            ptr = ptr.next;
            
        }
        
        return dummyHead.next;
    }

    private ListNode reverseGroup(ListNode head, int k) {
        // return reversed head
        ListNode curr = head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        ListNode next = head.next;
        for(int i=0; i<k-1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        dummyHead.next.next = next;
        // printNodes(curr);
        return curr;
    }

    private boolean hasNextK(ListNode node, int k) {
        for(int i=0; i<k; node = node.next, i++) {
            if(node == null){
                return false;
            }
        }
        return true;
    }

    private void printNodes(ListNode node) {
        while(node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}