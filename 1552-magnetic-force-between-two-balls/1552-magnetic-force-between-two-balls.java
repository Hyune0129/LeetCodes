class Solution {
    int distance = 0;
    int m,n;
    int[] position;
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        this.position = position;
        this.n = position.length;
        if(m == 2) {
            return position[n - 1] - position[0];
        }
        this.m = m;
        
        int start = 0;
        int end = position[n - 1];
        int middle;
        while(start < end) {
            middle = (start + end) / 2;
            if(canSetDistance(middle)) {
                distance = Math.max(middle, distance);
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return distance;
    }

    private boolean canSetDistance(int d) {
        int count = 1; // set pos[0]
        int preIndex = 0;
        int index = 1;
        while(index < n) {
            if(position[index] - position[preIndex] >= d) {
                count++;
                preIndex = index;
                if(count == m) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }
}