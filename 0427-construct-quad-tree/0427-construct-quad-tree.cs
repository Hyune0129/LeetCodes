/*
// Definition for a QuadTree node.
public class Node {
    public bool val;
    public bool isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        val = false;
        isLeaf = false;
        topLeft = null;
        topRight = null;
        bottomLeft = null;
        bottomRight = null;
    }
    
    public Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = null;
        topRight = null;
        bottomLeft = null;
        bottomRight = null;
    }
    
    public Node(bool _val,bool _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
*/

public class Solution {
    private int[][] grid;
    public Node Construct(int[][] grid) {
        this.grid = grid;
        return Recursion(0, grid.Length - 1, 0, grid[0].Length - 1);
    }


    private Node Recursion(int rowStart, int rowEnd, int colStart, int colEnd) {
        Node node = new Node();
        if(checkLeaf(rowStart, rowEnd, colStart, colEnd)){
            node.val = grid[rowStart][colStart] == 1 ? true : false;
            node.isLeaf = true;
            return node;
        }

        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;
        
        node.topLeft = Recursion(rowStart, rowMid, colStart, colMid);
        node.topRight = Recursion(rowStart, rowMid, colMid + 1, colEnd);
        node.bottomLeft = Recursion(rowMid + 1, rowEnd, colStart, colMid);
        node.bottomRight = Recursion(rowMid + 1, rowEnd, colMid + 1, colEnd);
        return node;
    }

    private bool checkLeaf(int rowStart, int rowEnd, int colStart, int colEnd) {
        int val = grid[rowStart][colStart];
        for(int row = rowStart; row <= rowEnd; row++) {
            for(int col = colStart; col <= colEnd; col++) {
                if(grid[row][col] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}