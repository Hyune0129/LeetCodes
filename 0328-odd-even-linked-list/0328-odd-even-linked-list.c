/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* oddEvenList(struct ListNode* head) {
    if(head == NULL || head->next == NULL) {
        return head;
    }
    bool isOdd = true;
    struct ListNode *ptr = head;
    struct ListNode *dummyHead1 = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *dummyHead2 = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *ptr1 = dummyHead1;
    struct ListNode *ptr2 = dummyHead2;
    while(ptr != NULL) {
        if(isOdd) {
            ptr1->next = ptr;
            ptr1 = ptr1->next;
        } else { // even
            ptr2->next = ptr;
            ptr2 = ptr2->next;
        }

        ptr = ptr->next;
        isOdd = !isOdd;
    }
    // printf("exit\n");
    ptr1->next = dummyHead2->next;
    ptr2->next = NULL;
    // printListNodes(dummyHead1->next);
    return dummyHead1->next;
}

void printListNodes(struct ListNode* node) {
    while(node != NULL) {
        printf("%d ->", node->val);
        node = node->next;
    }
}