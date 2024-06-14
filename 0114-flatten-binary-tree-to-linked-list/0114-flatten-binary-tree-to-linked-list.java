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
    TreeNode ptr;
    public void flatten(TreeNode root) {
        TreeNode dummyRoot = new TreeNode(-1);
        if(root == null) {
            return;
        }
        dummyRoot.right = root;
        ptr = dummyRoot;
        flattenRecursion(root);
    }

    private void flattenRecursion(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        ptr.left = null;
        ptr.right = node;
        ptr = ptr.right;

        flattenRecursion(left);
        flattenRecursion(right);
    }
}