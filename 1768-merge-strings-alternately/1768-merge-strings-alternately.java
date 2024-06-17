class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index1 =0, index2 = 0;
        while(index1 < word1.length() && index2 < word2.length()) {
            sb.append(word1.charAt(index1));
            sb.append(word2.charAt(index2));
            index1++;
            index2++;
        }
        for(; index1 < word1.length(); index1++) {
            sb.append(word1.charAt(index1));
        }
        for(; index2 < word2.length(); index2++) {
            sb.append(word2.charAt(index2));
        }
        return sb.toString();
    }
}