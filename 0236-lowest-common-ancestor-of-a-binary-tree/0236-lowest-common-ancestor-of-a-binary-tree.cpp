// ref : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/5668568/video-solution-intuition-explained-in-detail-c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || p == root || q == root) {
            return root;
        }
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if(left != NULL && right != NULL) { // case : p = 5, q = 1
            return root;
        } else if(left != NULL) {
            // not child p,q in right
            return left;
        } else { // right != NULL
            return right;
        }
    }
};