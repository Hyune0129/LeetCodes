/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode p, q;
    Stack<TreeNode> mem = new Stack<>(); // mem traveral
    Stack<TreeNode> pStack;
    Stack<TreeNode> qStack;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        traveral(root);
        while(pStack.size() > qStack.size()) {
            pStack.pop();
        }

        while(pStack.size() < qStack.size()) {
            qStack.pop();
        }

        while(!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();
            if(pNode.val == qNode.val) {
                return pNode;
            }
        }
        return null;
    }

    private void traveral(TreeNode node) {
        if(node == null) {
            return;
        }
        mem.push(node);
        if(p.val == node.val) {
            pStack = (Stack<TreeNode>)mem.clone();
        } else if(q.val == node.val) {
            qStack = (Stack<TreeNode>)mem.clone();
        }
        traveral(node.left);
        traveral(node.right);
        mem.pop();
    }
}