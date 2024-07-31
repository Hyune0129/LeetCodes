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
    public ListNode SortList(ListNode head) {
        if(head == null) {
            return head;
        }
        return recursion(head);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        // Console.WriteLine(head1.val + " " + head2.val);
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListNode head;
        ListNode ptr;
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;
        if(ptr1.val < ptr2.val) {
            ptr = ptr1;
            ptr1 = ptr1.next;
        } else {
            ptr = ptr2;
            ptr2 = ptr2.next;
        }
        head = ptr;
        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val < ptr2.val) {
                ptr.next = ptr1;
                ptr = ptr1;
                ptr1 = ptr1.next;
            } else {
                ptr.next = ptr2;
                ptr = ptr2;
                ptr2 = ptr2.next;
            }
        }
        if(ptr1 != null) {
            ptr.next = ptr1;
        }
        if(ptr2 != null) {
            ptr.next = ptr2;
        }
        // printNode(head);
        return head;
    }
    private ListNode getMidNode(ListNode start) {
        ListNode ptr1 = start;
        ListNode ptr2 = start.next;

        while(ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        return ptr1;
    }

    private ListNode recursion(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMidNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        // printNode(head);
        
        mid.next = null;
        left = recursion(left);
        right = recursion(right);
        ListNode res = merge(left, right);
        return res;
    }

    private void printNode(ListNode start) {
        ListNode ptr = start;
        while(ptr != null) {
            Console.Write(ptr.val + " -> ");
            ptr = ptr.next;
        }
        Console.WriteLine();
    }
}