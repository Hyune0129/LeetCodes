/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Queue<Node> queue = new LinkedList<>();
    public Node connect(Node root) {
        Node ptr = root;
        Node node, temp;
        do {
            for(; ptr != null; ptr = ptr.next) {
                if(ptr.left != null) {
                    queue.add(ptr.left);
                }
                if(ptr.right != null) {
                    queue.add(ptr.right);
                }
            }
            ptr = queue.peek();
            node = queue.poll();
            while(!queue.isEmpty()) {
                temp = queue.poll();
                node.next = temp;
                node = node.next;
            }
        } while(ptr != null);
        return root;    
    }
}