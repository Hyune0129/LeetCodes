public class Solution {
    public int EqualPairs(int[][] grid) {
        int n = grid.Length;
        int answer = 0;
        Dictionary<string, int> rowDic = new Dictionary<string, int>();
        StringBuilder sb = new StringBuilder();
        for(int c=0; c<n; c++) {
            for(int r=0; r<n; r++) {
                sb.Append(grid[r][c]);
                sb.Append(' ');
            }
            rowDic[sb.ToString()] = rowDic.GetValueOrDefault(sb.ToString(), 0) + 1;
            sb.Clear();
        }
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                sb.Append(grid[r][c]);
                sb.Append(' ');
            }
            answer += rowDic.GetValueOrDefault(sb.ToString(), 0);
            sb.Clear();
        }
        return answer;
    }
}