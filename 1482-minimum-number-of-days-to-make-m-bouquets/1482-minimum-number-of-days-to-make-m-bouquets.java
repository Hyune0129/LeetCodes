class Solution {
    int[] bloomDay;
    int n, m, k;
    public int minDays(int[] bloomDay, int m, int k) {
        int day = Integer.MAX_VALUE;
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        int[] sortedDay = bloomDay.clone();
        Arrays.sort(sortedDay);
        n = bloomDay.length;
        int left = 0;
        int right = n - 1;
        int middle;
        while(left <= right) {
            middle = (left + right) / 2;
            if(checkDay(sortedDay[middle])) {
                day = Math.min(day, sortedDay[middle]);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return day == Integer.MAX_VALUE ? -1 : day;
    }

    private boolean checkDay(int day) {
        int streak = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(bloomDay[i] <= day) {
                streak++;
                if(streak == k) {
                    count++;
                    if(count == m) {
                        return true;
                    }
                    streak = 0;
                }
            } else {
                streak = 0;
            }
        }
        return false;
    }

}