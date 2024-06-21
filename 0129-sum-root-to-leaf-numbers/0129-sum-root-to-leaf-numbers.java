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
    int answer = 0;
    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return answer;
    }

    private void inorder(TreeNode node, int num) {
        num += node.val;
        if(node.left != null) {
            inorder(node.left, num * 10);
        }
        if(node.right != null) {
            inorder(node.right, num * 10);
        }
        if(node.left == null && node.right == null) {
            answer += num;
        }
    }
}