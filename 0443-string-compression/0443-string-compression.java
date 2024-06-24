class Solution {
    char[] chars;
    int len = 0;
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }
        this.chars = chars;
        char pre = chars[0];
        
        int index = 1;
        int streak = 1;
        for(int i=1; i<chars.length; i++) {
            if(chars[i] != pre) {
                modifyChars(pre, streak);
                pre = chars[i];
                streak = 1;
            } else {
                streak++;
            }
        }
        modifyChars(pre, streak);
        return len;
    }

    private void modifyChars(char c, int count) {
        if(count == 1) {
            chars[len++] = c;
            return;
        }
        String str = String.valueOf(count);
        chars[len++] = c;
        for(char num : str.toCharArray()) {
            chars[len++] = num;
        }
        
    }
}