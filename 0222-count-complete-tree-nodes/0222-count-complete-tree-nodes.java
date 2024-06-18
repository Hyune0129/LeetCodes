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
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        inorder(root);
        return count;
    }

    private void inorder(TreeNode node) {
        if(node == null) {
            return;
        }
        count++;
        inorder(node.left);
        inorder(node.right);
    }
}