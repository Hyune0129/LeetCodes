/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> answer = new ArrayList<>();;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return answer;
        }
        traversal(root);

        return answer;
    }

    private void traversal(TreeNode root) {
        Deque<TreeNode> oddDeque = new ArrayDeque<>();
        Deque<TreeNode> evenDeque = new ArrayDeque<>();
        TreeNode node;
        int depth = 0;
        evenDeque.add(root);
        while(!oddDeque.isEmpty() || !evenDeque.isEmpty()) {
            if(!evenDeque.isEmpty()) {
                answer.add(new ArrayList<Integer>());
            }
            while(!evenDeque.isEmpty()) {
                node = evenDeque.pollFirst();
                answer.get(depth).add(node.val);
                if(node.left != null) {
                    oddDeque.addLast(node.left);
                }
                if(node.right != null) {
                    oddDeque.addLast(node.right);
                }
            }
            depth++;
            if(!oddDeque.isEmpty()) {
                answer.add(new ArrayList<Integer>());
            }
            while(!oddDeque.isEmpty()) {
                node = oddDeque.pollLast();
                answer.get(depth).add(node.val);
                if(node.right != null) {
                    evenDeque.addFirst(node.right);
                }
                if(node.left != null) {
                    evenDeque.addFirst(node.left);
                }
            }
            depth++;
        }
    }
    
}