/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    final int MIN_VALUE = -10000;
    int ans = MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ans;
    }

    private int getMax(TreeNode node) {
        if(node == null) {
            return MIN_VALUE;
        }
        int val = node.val;
        int leftMax = getMax(node.left);
        int rightMax = getMax(node.right);
        ans = Math.max(ans, val);
        ans = Math.max(ans, val + leftMax +rightMax);
        ans = Math.max(ans, val + leftMax);
        ans = Math.max(ans, val + rightMax);
        return Math.max(val, Math.max(val + leftMax, val + rightMax));
    }
}