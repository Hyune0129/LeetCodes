class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // most less pos student should sit most less pos seat.
        PriorityQueue<Integer> seatHeap = new PriorityQueue<>();
        PriorityQueue<Integer> stuHeap = new PriorityQueue<>();
        for(int i=0; i<seats.length; i++) {
            seatHeap.add(seats[i]);
            stuHeap.add(students[i]);
        }
        int ans = 0;
        while(!seatHeap.isEmpty()) {
            ans += Math.abs(seatHeap.poll() - stuHeap.poll());
        }
        return ans;
    }
}