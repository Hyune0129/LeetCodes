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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode ptr;
    public BSTIterator(TreeNode root) {
        ptr = root;
        while(ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
    }
    
    public int next() {
        ptr = stack.pop();
        int v = ptr.val;
        ptr = ptr.right;
        while(ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
        return v;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */