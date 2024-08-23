#include <stack>
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
        int sum = 0;
        int maxSum = 0;
        ListNode* ptr1 = head;
        ListNode* ptr2 = head;
        std::stack<int> stack;
        while(ptr2->next != NULL && ptr2->next->next != NULL) {
            stack.push(ptr1->val);
            ptr1 = ptr1->next;
            ptr2 = ptr2->next->next;
        }
        stack.push(ptr1->val);
        ptr1 = ptr1->next;
        while(ptr1 != NULL) {
            sum = ptr1->val + stack.top();
            stack.pop();
            maxSum = std::max(sum, maxSum);
            ptr1 = ptr1->next;
        }

        return maxSum;
    }
};