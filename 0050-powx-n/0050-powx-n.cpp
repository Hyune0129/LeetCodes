class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        long time = n;
        double ans = 1;
        bool isMinusPow = false;
        if(time < 0) { 
            isMinusPow = true;
            time *= -1; // n = -2147483648 case use long
        }
        while(time > 0) {
            if(time % 2 == 1) {
                ans = ans * x;
            }
            x *= x;
            time /= 2;
        }
    
        if(isMinusPow) {
            return 1 / ans;
        } else {
            return ans;
        }   
    }
};