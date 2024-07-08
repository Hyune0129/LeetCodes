class Solution {
    final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = k;
        int max = 0;
        int curr = 0;
        for(int i = 0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                curr++;
            }
        }
        max = curr;
        for(; right < s.length(); left++, right++) {
            if(isVowel(s.charAt(left))) {
                curr--;
            }
            if(isVowel(s.charAt(right))) {
                curr++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
    
    private boolean isVowel(char c) {
        for(char vowel : VOWELS) {
            if(c == vowel) {
                return true;
            }
        }
        return false;
    }
}