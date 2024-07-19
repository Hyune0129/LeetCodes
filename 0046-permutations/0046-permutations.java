class Solution {
    Integer[] mem;
    boolean[] isVisited;
    List<List<Integer>> answer;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        this.nums = nums;
        isVisited = new boolean[nums.length];
        mem = new Integer[nums.length];
        backTracking(0);
        return answer;
    }
    private void backTracking(int depth) {
        if(depth == nums.length) {
            answer.add(Arrays.asList(mem.clone()));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            mem[depth] = nums[i];
            backTracking(depth + 1);
            isVisited[i] = false;
        }
    }
}