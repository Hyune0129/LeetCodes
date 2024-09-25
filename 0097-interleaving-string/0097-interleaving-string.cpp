// ref : https://leetcode.com/problems/interleaving-string/solutions/208101/python-dp-time-o-mn-space-o-n-n-len-s2
// use space O(s2.length), time(O(s1.len * s2.len))

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if(s1.length() == 0) { // s1 = ""
            return s2.compare(s3) == 0;
        } else if(s2.length() == 0) { // s2 = ""
            return s1.compare(s3) == 0;
        }

        vector<bool> v(s2.length() + 1);
        // v[j] ==  can make using s1 [0,i), s2[0, j) to s3[0,i+j)
        int idx; // s1's idx
        bool match1, match2;
        v[0] = true;
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i == j && i == 0) // i == j == 0
                    continue;
                if(i > 0) {
                    // use s1
                    match1 = v[j] && s1[i-1] == s3[i+j-1];
                }
                else {
                    match1 = false;
                }
                if(j > 0) {
                    // use s2
                    match2 = v[j-1] && s2[j-1] == s3[i+j-1];
                } else {
                    match2 = false;
                }

                // can make using s1 or s2
                v[j] = match1 or match2;
            }
        }
        return v[s2.length()];
    }
};