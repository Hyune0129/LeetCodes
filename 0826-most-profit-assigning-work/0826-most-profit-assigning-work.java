class Solution {
    class Work{
        int profit;
        int difficulty;
        Work(int p, int d) {
            profit = p;
            difficulty = d;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int n = difficulty.length;
        int m = worker.length;
        Arrays.sort(worker);
        List<Work> works = new ArrayList<>();
        for(int i=0; i<n; i++) {
            works.add(new Work(profit[i], difficulty[i]));
        }
        Collections.sort(works, new Comparator<Work>(){
            public int compare(Work a, Work b) {
                return b.profit - a.profit; // sorting reverseOrder
            }
        });
        int workerIndex = worker.length - 1;
        int workIndex = 0;
        for(Work work : works) {
            while(workerIndex >= 0 && worker[workerIndex] >= work.difficulty) {
                ans += work.profit;
                workerIndex--;
            }
        }
        return ans;
    }
}