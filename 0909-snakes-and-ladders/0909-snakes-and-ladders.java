class Solution {
    class Position {
        int pos;
        int diceCount;

        Position(int pos, int diceCount) {
            this.pos = pos;
            this.diceCount = diceCount;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int[] flattenBoard = flatBoard(board);
        int m = flattenBoard.length;
        int[] travelTimes = new int[flattenBoard.length];
        Arrays.fill(travelTimes, m + 1);
        travelTimes[0] = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        boolean[] isVisited = new boolean[m];
        isVisited[0] = true;
        Position pos;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int dice = 1; dice <= 6; dice++) {
                int dicedPos = pos.pos + dice;
                if (dicedPos >= m) {
                    continue;
                }
                if (isVisited[dicedPos]) {
                    continue;
                }
                isVisited[dicedPos] = true;
                
                if (flattenBoard[dicedPos] != -1) {
                    travelTimes[flattenBoard[dicedPos] - 1] = Math.min(travelTimes[flattenBoard[dicedPos] - 1],
                            travelTimes[pos.pos] + 1);
                    queue.add(new Position(flattenBoard[dicedPos] - 1, pos.diceCount + 1));
                } else {
                    travelTimes[dicedPos] = Math.min(pos.diceCount + 1, travelTimes[dicedPos]);
                    queue.add(new Position(dicedPos, pos.diceCount + 1));
                }
            }
        }
        // for (int num : flattenBoard) {
        //     System.out.print(num + " ");
        // }
        // System.out.println();
        // System.out.println("====================");
        // for (int num : travelTimes) {
        //     System.out.print(num + " ");
        // }
        if (travelTimes[m-1] == m + 1) { // not visited
            return -1;
        }
        return travelTimes[m - 1];
    }

    private int[] flatBoard(int[][] board) {
        int n = board.length;
        int[] flattenBoard = new int[n * n];
        boolean isIncreseRight = true;
        for (int idx = 0, row = n - 1; row >= 0; row--) {
            int col = isIncreseRight ? 0 : n - 1;
            while (col >= 0 && col < n) {
                flattenBoard[idx++] = board[row][col];
                if (isIncreseRight) {
                    col++;
                } else {
                    col--;
                }
            }
            isIncreseRight = !isIncreseRight;
        }
        return flattenBoard;
    }
}