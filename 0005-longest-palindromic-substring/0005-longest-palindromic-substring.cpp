class Solution {
public:
    string longestPalindrome(string s) {
        // two pointer n^2
        if (s.size() == 1) {
            return s;
        } 
        // init
        int left = 0;
        int right = 0;
        int max = 0;
        int len = 0;
        string ans = "";
        for (int i = 0; i < s.size(); i++) {
            left = i - 1;
            right = i + 1;
            len = 1;
            while (left >= 0 && right < s.size() && s[left] == s[right]) {
                len += 2;
                right++;
                left--;
            }
            if (max < len) {
                max = len;
                ans = s.substr(left + 1, len);
            }
            if (s[i] == s[i + 1]) {
                left = i - 1;
                right = i + 2;
                len = 2;
                while (left >= 0 && right < s.size() && s[left] == s[right]) {
                    len+= 2;
                    right++;
                    left--;
                }
                if (max < len) {
                    max = len;
                    ans = s.substr(left + 1, len);
                }
            }
        }
        return ans;
    }
};