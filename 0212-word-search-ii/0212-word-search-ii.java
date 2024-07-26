class Solution {
    class Node {
        Node[] nodes = new Node['z' - 'a' + 1];
        boolean isEnd = false;
    }

    Node root = new Node();
    boolean[][] isVisited;
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m, n;
    char[][] board;
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        this.board = board;
        for(String word : words) {
            insertTrie(word);
        }
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(root.nodes[board[row][col] - 'a'] != null) {
                    isVisited[row][col] = true;
                    sb.append(board[row][col]);
                    findInTrie(row, col, root.nodes[board[row][col] - 'a']);
                    sb.setLength(sb.length() - 1);
                    isVisited[row][col] = false;
                }
            }
        }
        List<String> answer = new ArrayList<>(set);
        return answer;
    }

    public void insertTrie(String str) {
        Node ptr = root;
        int index = 0;
        while (index < str.length() && ptr.nodes[str.charAt(index) - 'a'] != null) {
            ptr = ptr.nodes[str.charAt(index++) - 'a'];
        }
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            Node temp = new Node();
            ptr.nodes[c - 'a'] = temp;
            ptr = ptr.nodes[c - 'a'];
        }
        ptr.isEnd = true;
    }

    public void findInTrie(int row, int col, Node ptr) {
        // backTracking
        if (ptr.isEnd) {
            set.add(sb.toString());
        }
        for (int d = 0; d < 4; d++) {
            int nr = dr[d] + row;
            int nc = dc[d] + col;

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if (isVisited[nr][nc]) {
                continue;
            }
            if (ptr.nodes[board[nr][nc] - 'a'] != null) {
                isVisited[nr][nc] = true;
                sb.append(board[nr][nc]);
                findInTrie(nr, nc, ptr.nodes[board[nr][nc] - 'a']);
                sb.setLength(sb.length() - 1);
                isVisited[nr][nc] = false;
            }

        }
    }

}