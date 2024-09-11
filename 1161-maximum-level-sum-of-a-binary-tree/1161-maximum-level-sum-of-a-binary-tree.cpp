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
    const int DUMMY_VAL = 1000000;
public:
    int maxLevelSum(TreeNode* root) {
        int maxSum = root->val;
        int maxLevel = 1;
        int level = 1;
        std::queue<struct TreeNode*> q;
        struct TreeNode* node;
        q.push(root);
        while(!q.empty()) {
            int sum = 0;
            q.push(new TreeNode(DUMMY_VAL));
            while(q.front()->val != DUMMY_VAL) {
                node = q.front();
                q.pop();
                sum += node->val;
                if(node->left != NULL) {
                    q.push(node->left);
                }
                if(node->right != NULL) {
                    q.push(node->right);
                }
            }
            q.pop();
            
            if(maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
};