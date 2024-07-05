/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    boolean[] isVisited;
    Node[] nodes;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        nodes = new Node[101];
        nodes[1] = new Node(node.val);
        isVisited = new boolean[101];
        isVisited[1] = true;
        traversal(node);
        return nodes[1];
    }

    private void traversal(Node node) {
        for(Node n : node.neighbors) {
            if(!isVisited[n.val]) {
                nodes[n.val] = new Node(n.val);
                isVisited[n.val] = true;
                traversal(n);
            }
            nodes[node.val].neighbors.add(nodes[n.val]);
        }
    }
}