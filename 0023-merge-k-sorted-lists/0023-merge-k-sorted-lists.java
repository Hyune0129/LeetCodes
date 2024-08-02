/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        int leftNode = lists.length;
        int mergedCount;
        while (leftNode > 1) {
            mergedCount = 0;
            for (int i = 0; i < leftNode / 2; i++){
                lists[i] = merge(lists[i], lists[leftNode - i - 1]);
                mergedCount++;
            }
            leftNode -= mergedCount;
        }
        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head;
        ListNode ptr;
        if (a.val < b.val) {
            ptr = a;
            a = a.next;
        } else { // a.val < b.val
            ptr = b;
            b = b.next;
        }
        head = ptr;
        while (a != null && b != null) {
            if (a.val < b.val) {
                ptr.next = a;
                a = a.next;
            } else { // a.val < b.val
                ptr.next = b;
                b = b.next;
            }
            ptr = ptr.next;
        }
        if (a == null) {
            ptr.next = b;
        }
        if (b == null) {
            ptr.next = a;
        }
        return head;
    }
}