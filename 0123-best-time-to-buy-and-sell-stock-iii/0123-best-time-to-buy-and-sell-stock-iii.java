class Solution {
    static final int MAX_PRICE = 100000;
    int[][][] profit; // [dont have stock | have stock][left transactions][day]
                      // val = current money
    public int maxProfit(int[] prices) {
        profit = new int[2][3][prices.length];
        Arrays.fill(profit[1][2], -MAX_PRICE);
        Arrays.fill(profit[1][1], -MAX_PRICE);
        for(int t = 2; t > 0; t--) { // transactions
            profit[1][t][0] = -prices[0]; // init
            for(int day = 1; day < prices.length; day++) {
                profit[0][t-1][day] = Math.max(profit[0][t-1][day-1], profit[1][t][day-1] + prices[day]);  //sell
                profit[1][t][day] = Math.max(profit[1][t][day-1], profit[0][t][day]-prices[day]); // buy
            }
        }
        
        int ans = 0;
        for(int t = 2; t>=0; t--){
            ans = Math.max(profit[0][t][prices.length-1], ans);
        }
        // System.out.println(0);
        // printMatrix(profit[0]);
        // System.out.println(1);
        // printMatrix(profit[1]);
        
        return ans;
    }

    private void printMatrix(int[][] matrix) {
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[r].length; c++) {
                if(matrix[r][c] == -MAX_PRICE) {
                    System.out.print("- ");
                } else {
                    System.out.print(matrix[r][c] + " ");
                }
            }
            System.out.println();
        }
    }
}