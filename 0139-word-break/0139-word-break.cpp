class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        bool isBreakable[301] = {false, };
        isBreakable[0] = true;
        for(int i=0; i<s.size(); i++) {
            if(!isBreakable[i]) {
                continue;
            }
            for(string word : wordDict) {
                // std::cout << i + word.size() << endl;
                if(i + word.size() > s.size() ){
                    continue;
                }
                
                if(std::strncmp(word.c_str(), s.c_str() + i,word.size()) == 0) {
                    isBreakable[word.size() + i] = true;
                }
            }
        }
        return isBreakable[s.size()];
    }
};