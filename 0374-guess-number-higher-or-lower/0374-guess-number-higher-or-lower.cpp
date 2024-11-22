/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        long left = 0;
        long right = n+1L;
        int picked = -1;
        int resultApi = 2;
        while(resultApi != 0)
        {
            picked = (left + right) / 2;
            resultApi = guess(picked);
            if(resultApi == 1) { // mypicked < corrected
                left = picked;
            } else { // mypicked >= corrected
                right = picked;
            }
        }
        return picked;
    }
};