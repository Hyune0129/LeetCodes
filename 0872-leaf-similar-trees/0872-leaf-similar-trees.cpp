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
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> values1;
        vector<int> values2;
        getLeafValues(root1, &values1);
        getLeafValues(root2, &values2);
        if(values1.size() != values2.size()) {
            return false;
        }
        for(int i=0; i<values1.size(); i++) {
            // cout << values1[i] << " " << values2[i] << endl;
            if(values1[i] != values2[i]) {
                return false;
            }
        }
        return true;
    }
    void getLeafValues(TreeNode* node, vector<int>* leafValues) {
        if(node->left == NULL && node->right == NULL) { // leafnode
            leafValues->push_back(node->val);
            return;
        }
        if(node->left != NULL){
            getLeafValues(node->left, leafValues);
        }
        if(node->right != NULL) {
            getLeafValues(node->right, leafValues);
        }
    }
};