// reference : https://leetcode.com/problems/delete-node-in-a-bst/solutions/5789246/java-easy-solution-beats-100
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
    TreeNode* inorder(TreeNode* node) {
    while(node->left != NULL) {
        node = node->left;
    }
    return node;
}
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) {
            return root;
        }
        if(root->val > key) {
            root->left = deleteNode(root->left, key);
        } else if(root->val < key) {
            root->right = deleteNode(root->right, key);
        } else {
            if(root->left == NULL && root->right == NULL) {
                return NULL;
            }
            if(root->left==NULL || root->right == NULL) {
                return root->left == NULL ? root->right : root->left;
            }
            TreeNode* x = inorder(root->right);
            root->val = x->val;
            root->right = deleteNode(root->right, x->val);
        }

        return root;
    }
};