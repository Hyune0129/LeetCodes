public class Solution {
    public bool CloseStrings(string word1, string word2) {
        if(word1.Length != word2.Length) {
            return false;
        }
        Dictionary<char, int> dic1 = new Dictionary<char, int>();
        Dictionary<char, int> dic2 = new Dictionary<char, int>();
        foreach(char letter in word1) {
            dic1[letter] = dic1.GetValueOrDefault(letter, 0) + 1;
        }
        foreach(char letter in word2) {
            dic2[letter] = dic2.GetValueOrDefault(letter, 0) + 1;
        }
        foreach(char letter in dic1.Keys) {
            if(!dic2.ContainsKey(letter)) {
                return false;
            }
        }
        Dictionary<int, int> counter1 = new Dictionary<int, int>();
        Dictionary<int, int> counter2 = new Dictionary<int, int>();
        foreach(int count in dic1.Values) {
            counter1[count] = counter1.GetValueOrDefault(count, 0) + 1;
        }
        foreach(int count in dic2.Values) {
            counter2[count] = counter2.GetValueOrDefault(count, 0) + 1;
        }
        foreach(KeyValuePair<int, int> pair in counter1) {
            if(pair.Value != counter2.GetValueOrDefault(pair.Key, -1)) {
                return false;
            }
        }
        return true;
    }
}