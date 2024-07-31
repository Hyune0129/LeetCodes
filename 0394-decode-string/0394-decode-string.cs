public class Solution {

    public string DecodeString(string s) {
        StringBuilder sb = new StringBuilder();
        Stack<int> multipleStack = new Stack<int>();
        Stack<StringBuilder> sbStack = new Stack<StringBuilder>();
        int digit = 0;
        foreach(char c in s) {
            switch(c) {
                case '[': // before all digit
                    multipleStack.Push(digit);
                    sbStack.Push(sb);
                    sb = new StringBuilder();
                    digit = 0;
                    break;
                case ']':
                    int num = multipleStack.Pop();
                    StringBuilder temp = sb;
                    sb = sbStack.Pop();
                    for(int i=0; i<num; i++) {
                        sb.Append(temp);
                    }
                    break;
                default:
                    if(Char.IsDigit(c)) {
                        digit = digit * 10 + (c - '0');
                    } else {
                        sb.Append(c);
                    }
                    break;
            }
        }
        return sb.ToString();
    }

}