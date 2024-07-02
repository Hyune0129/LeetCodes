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
    Integer pre;
    public boolean isValidBST(TreeNode root) {
        return traversal(root);
    }

    private boolean traversal(TreeNode node) { // inorder => sorted?
        if(node == null){
            return true;
        }
        if(!traversal(node.left)){
            return false;
        }
        if(pre != null && node.val <= pre) {
            return false;
        }
        pre = node.val;
        return traversal(node.right);
    }

}