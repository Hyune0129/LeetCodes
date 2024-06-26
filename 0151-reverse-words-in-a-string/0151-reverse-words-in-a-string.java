class Solution {
    public String reverseWords(String s) { //O(n) mem
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(int i=strs.length-1; i>=0; i--) {
            if(!strs[i].equals(""))
                sb.append(strs[i] + " ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}