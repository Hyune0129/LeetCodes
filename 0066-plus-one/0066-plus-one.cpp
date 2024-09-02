class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        bool isNextDigitPlus = true;
        int index = digits.size() - 1;
        while(isNextDigitPlus && index >= 0) {
            isNextDigitPlus = false;
            digits[index]++;
            if(digits[index] == 10) {
                digits[index] = 0;
                isNextDigitPlus = true;
            }
            index--;
        }
        if(isNextDigitPlus) {
            digits.insert(digits.begin(), 1);
        }
        return digits;
    }
};