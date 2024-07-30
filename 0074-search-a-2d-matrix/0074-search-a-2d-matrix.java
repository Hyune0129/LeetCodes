class Solution {
    private boolean binarySearch(int[] array, int target) {
        if(array.length == 1) {
            return array[0] == target;
        } else if(array.length == 2) {
            return array[0] == target || array[1] == target;
        }
        int left = -1;
        int right = array.length;
        while(left + 1 < right) {
            int middle = (left + right) / 2;
            if(array[middle] == target) {
                return true;
            }
            if(array[middle] < target) {
                left = middle;
            }
            else {
                right = middle;
            }
        }
        return false;
    }

    private int binarySearchByRow(int[][] matrix, int target) {
        if(matrix.length == 1) {
            return 0;
        }
        else if(matrix.length == 2) {
            if(matrix[1][0] <= target) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = -1;
        int right = matrix.length;
        while(left + 1< right) {
            int middle = (left + right) / 2;
            if(matrix[middle][0] <= target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchByRow(matrix, target);
        if(row < 0 || row >= matrix.length) {
            return false;
        }
        // System.out.println(row);
        return binarySearch(matrix[row], target);
    }
}