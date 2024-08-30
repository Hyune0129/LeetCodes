/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    const int MIN_VALUE = -100000;
    int count;
public:
    
    int goodNodes(TreeNode* root) {
        count = 0;
        inorder(root, MIN_VALUE);
        return count;
    }

    void inorder(TreeNode* node, int maxValue) {
        if(node == NULL) {
            return;
        }
        if(maxValue <= node->val ) {
            count++;
            maxValue = node->val;
        }
        inorder(node->left, maxValue);
        inorder(node->right, maxValue);
    }
};