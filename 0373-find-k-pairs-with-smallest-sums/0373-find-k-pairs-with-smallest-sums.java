// reference : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/solutions/5197679/the-k-pattern

class Solution {
    class Pair{
        int num1;
        int num2;
        int idx2;
        int sum;
        Pair(int n1, int n2, int i2) {
            num1 = n1;
            num2 = n2;
            idx2 = i2;
            sum = num1 + num2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<Pair> pairsHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair x, Pair y) {
                return (x.sum) - (y.sum);
            }
        });
        for(int i = 0; i < nums1.length; i++) {
            pairsHeap.add(new Pair(nums1[i], nums2[0], 0));
        }
        int count = 0;
        while(count < k) {
            Pair pair = pairsHeap.poll();
            pairs.add(List.of(pair.num1, pair.num2));
            count++;
            if(pair.idx2 == nums2.length - 1) {
                continue;
            }
            pairsHeap.add(new Pair(pair.num1, nums2[pair.idx2 + 1], pair.idx2 + 1));
        }
        return pairs;
    }

}