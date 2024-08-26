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
        int ans = 0;
    public:
        int maxDepth(TreeNode* root) {
            inorder(root, 1);
            return ans;
        }
        void inorder(TreeNode* node, int depth) {
            if(node == NULL) {
                return;
            }
            ans = std::max(ans, depth);
            inorder(node->left, depth + 1);
            inorder(node->right, depth + 1);
        }
};