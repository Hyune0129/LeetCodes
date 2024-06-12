class Solution {
    final int MIN_VALUE = -10000;
    public int maxProfit(int k, int[] prices) {
        // [0: dont have stock / 1 : have stock][left buy/sell times][day]
        int[][][] profits = new int[2][k + 1][prices.length]; 
        for(int i=0; i<k; i++) {
            Arrays.fill(profits[1][i], MIN_VALUE);
        }
        profits[1][k][0] = -prices[0]; // buy
        for(int i=k; i>0; i--) {
            for(int day = 1; day < prices.length; day++) {
                //sell stock
                profits[0][i-1][day] = Math.max(profits[0][i-1][day-1], profits[1][i][day-1] + prices[day]);
                //buy stock
                profits[1][i][day] = Math.max(profits[1][i][day-1], profits[0][i][day-1]-prices[day]);
            
            }
        }
        // System.out.println(0);
        // printMatrix(profits[0]);
        // System.out.println(1);
        // printMatrix(profits[1]);
        int ans = MIN_VALUE;
        for(int i=0; i<=k; i++) {
            ans = Math.max(ans, profits[0][i][prices.length-1]);
        }
        return ans;
    }

    private void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == MIN_VALUE) {
                    System.out.print("M"+" ");
                } else 
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}