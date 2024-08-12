/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    if(head == NULL || head->next == NULL) {
        return head;
    }
    struct ListNode* curr = head;
    struct ListNode* prev = NULL;
    struct ListNode* next = head->next;
    while(next != NULL) {
        curr->next = prev;
        prev = curr;
        curr = next;
        next = next->next;
    }
    curr->next = prev;
    return curr;
}