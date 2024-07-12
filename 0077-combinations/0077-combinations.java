class Solution {
    int n, k ;
    List<List<Integer>> answer;
    boolean[] isVisited;
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        isVisited = new boolean[n+1];
        this.n = n;
        this.k = k;
        solve(0, 0);
        return answer;
    }
    private void solve(int idx, int usedNum) {  // i -> k
        // backtracking
        if(idx == k) {
            List<Integer> ans = new ArrayList<>();
            for(int i=1; i<= n; i++) {
                if(isVisited[i]) {
                    ans.add(i);
                }
            }
            answer.add(ans);
            return;
        }
        for(int i=usedNum + 1; i <= n; i++) {
            if(isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            solve(idx + 1, i);
            isVisited[i] = false;
        }

    }  
}