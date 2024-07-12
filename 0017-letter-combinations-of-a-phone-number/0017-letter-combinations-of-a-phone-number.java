class Solution {
    List<String> answer;
    StringBuilder sb;
    String digits;
    final String[] phoneLetters = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        answer = new ArrayList<>();
        sb = new StringBuilder();
        if(digits.length() == 0) {
            return answer;
        }
        solve(0);
        return answer;
    }

    private void solve(int index) {
        if(index == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(int i=0; i<phoneLetters[digit].length(); i++) {
            sb.append(phoneLetters[digit].charAt(i));
            solve(index + 1);    
            sb.setLength(index);
        }
    }
}