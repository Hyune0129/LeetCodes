public class Solution {
    StringBuilder sb = new StringBuilder();
    IList<string> answer;
    int n;
    public IList<string> GenerateParenthesis(int n) {
        answer = new List<string>();
        this.n = n;
        BackTracking(0, 0);
        return answer;
    }

    private void BackTracking(int openCount, int closeCount) {
        if(openCount + closeCount >= n * 2) {
            int count = 0;
            for(int i=closeCount; i < n; i++) {
                count++;
                sb.Append(')');
            }
            answer.Add(sb.ToString());
            sb.Remove(sb.Length - count - 1, count);
            return;
        }
        if(openCount < n) {
            sb.Append('(');
            BackTracking(openCount + 1, closeCount);
            sb.Remove(sb.Length - 1, 1);
        }
        if(openCount > closeCount) {
            sb.Append(')');
            BackTracking(openCount, closeCount + 1);
            sb.Remove(sb.Length - 1, 1);
        }
    }
}