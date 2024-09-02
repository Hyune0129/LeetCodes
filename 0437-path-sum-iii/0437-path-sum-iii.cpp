// reference : https://leetcode.com/problems/path-sum-iii/solutions/5562768/video-solution-prefix-sum-intuition-explained-in-detail-c

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
    unordered_map<long, int> map;
    int target;
    int count;
public:
    int pathSum(TreeNode* root, int targetSum) {
        if(root == NULL) {
            return 0;
        }
        map[0] = 1;
        target = targetSum;
        count = 0;
        inorder(root, 0);
        return count;
    }
    void inorder(TreeNode* node, long prefixSum) {
        if(node == NULL) {
            return;
        }
        prefixSum += node->val;
        if(map.find(prefixSum - target) != map.end()) {
            // find prefixSum - "oldSum" = target
            count+=map[prefixSum - target];
        }

        // backtracking
        map[prefixSum]++;
        inorder(node->left, prefixSum);
        inorder(node->right, prefixSum);
        map[prefixSum]--;
    }
};