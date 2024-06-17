class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0)
            return true;
        for(int a=0; Math.pow(a, 2) <= c; a++) {
            double temp = Math.sqrt(c - Math.pow(a,2));
            // System.out.println(temp);
            if(temp == (int)temp) {
                return true;
            }
        }
        return false;
    }
}