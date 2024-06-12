class Solution {
    final int RED = 0;
    final int WHITE = 1;
    final int BLUE = 2;
    int nums[];

    public void sortColors(int[] nums) {
        this.nums = nums;
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        for (int i = 0; i < nums.length && i <= blueIdx; i++) {
            switch (nums[i]) {
                case RED:
                    while (i < redIdx && nums[redIdx] == RED)
                        redIdx++;
                    swap(i, redIdx++);
                    if (nums[i] == BLUE) {
                        swap(i, blueIdx--);
                    }
                    break;
                case BLUE:
                    while (i < blueIdx && nums[blueIdx] == BLUE)
                        blueIdx--;
                    swap(i, blueIdx--);
                    if (nums[i] == RED) {
                        swap(i, redIdx++);
                    }
                    break;
            }
            // printNums();
        }
    }

    private void swap(int index1, int index2) {
        System.out.println(index1 + " " + index2);
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void printNums() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}