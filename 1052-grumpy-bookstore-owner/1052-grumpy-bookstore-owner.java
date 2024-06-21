class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int answer = 0;
        int n = customers.length;
        int satisfy = 0;
        int[] customersInGrumpy = new int[n];
        for(int day = 0; day < n; day++) {
            if(grumpy[day] == 1) {
                customersInGrumpy[day] = customers[day];
            } else {
                answer += customers[day]; // const satisfy
            }
        }
        for(int i=0; i<minutes; i++) {
            satisfy += customersInGrumpy[i];
        }

        int start = 0;
        int end = minutes;
        int maxSatisfy = satisfy;
        while(end < n) {
            satisfy -= customersInGrumpy[start++];
            satisfy += customersInGrumpy[end++];
            
            maxSatisfy = Math.max(satisfy, maxSatisfy);
        }
        
        return answer + maxSatisfy;
        
    }

}