class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length <= 2) {
            int sum = 0;
            for (int num : flowerbed) {
                sum += num;
            }
            return sum == 0 ? true : false;
        }
        int index = 0;
        int prev = 0;
        int next = flowerbed[1];
        while (index < flowerbed.length) {
            if (prev + next + flowerbed[index] == 0) {
                n--;
                prev = 1;

                if (n == 0) {
                    return true;
                }
            } else {
                prev = flowerbed[index];
            }
            index++;
            if (index + 1 >= flowerbed.length) {
                next = 0;
            } else {
                next = flowerbed[index + 1];
            }
        }

        return false;
    }
}