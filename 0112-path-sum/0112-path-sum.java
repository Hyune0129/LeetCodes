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
    boolean answer = false;
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        this.targetSum = targetSum;
        inorderCheck(root, 0);
        return answer;
    }

    private void inorderCheck(TreeNode node, int num) {
        if(node == null) {
            if(num == targetSum){
                answer = true;
            }
            return;
        }
        inorderCheck(node.left, num + node.val);
        inorderCheck(node.right, num + node.val);
    }
}