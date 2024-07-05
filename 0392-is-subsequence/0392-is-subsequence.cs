public class Solution {
    public bool IsSubsequence(string s, string t) {
        int tIndex = 0;
        int sIndex = 0;
        while(sIndex < s.Length && tIndex < t.Length) {           
            while(tIndex < t.Length) {
                if(s[sIndex] == t[tIndex]) {
                    sIndex++;
                    tIndex++;
                    break;
                }
                tIndex++;
            }
            
        }
        return sIndex >= s.Length;
    }
}