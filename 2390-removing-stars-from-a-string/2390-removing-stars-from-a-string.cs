public class Solution {
    const char CLEANLETTER = '*';
    public string RemoveStars(string s) {
        StringBuilder sb = new StringBuilder();
        foreach(char c in s) {
            if(c == CLEANLETTER) {
                sb.Remove(sb.Length - 1, 1);
            } else {
                sb.Append(c);
            }
        }
        return sb.ToString();
    }
}