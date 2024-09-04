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
    int maxLen;
public:
    int longestZigZag(TreeNode* root) {
        maxLen = 0;
        dfs(root->left, 0, true);
        dfs(root->right, 0, false);
        return maxLen;
    }
    void dfs(TreeNode* node, int streak, bool isLeft) {
        if(node == NULL) {
            maxLen = std::max(maxLen, streak);
            return;
        }
        if(isLeft) {
            dfs(node->right, streak + 1, false);
            dfs(node->left, 0, true);
        } else {
            dfs(node->left, streak + 1, true);
            dfs(node->right, 0, false);
        }
    }
};