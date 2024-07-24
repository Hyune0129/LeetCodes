public class Solution {
    public string AddBinary(string a, string b) {
        StringBuilder answer = new StringBuilder();
        int reverseIdx = 0;
        bool isUpbit = false;
        while(a.Length > reverseIdx && b.Length > reverseIdx) {
            int x = a[a.Length - reverseIdx - 1] - '0';
            int y = b[b.Length - reverseIdx - 1] - '0';
            int num = x + y;
            if(isUpbit) {
                num++;
            }
            if(num >= 2) {
                isUpbit = true;
                num %= 2;
            } else {
                isUpbit = false;
            }
            answer.Append(num);
            reverseIdx++;
        }
        for(; reverseIdx < a.Length; reverseIdx++) {
            int x = a[a.Length - reverseIdx - 1] - '0';
            if(isUpbit) {
                x++;
            }
            if(x >= 2) {
                isUpbit = true;
                x %= 2;
            } else {
                isUpbit = false;
            }
            answer.Append(x);
        }
        for(; reverseIdx < b.Length; reverseIdx++) {
            int y = b[b.Length - reverseIdx - 1] - '0';
            if(isUpbit) {
                y++;
            }
            if(y >= 2) {
                isUpbit = true;
                y %= 2;
            } else {
                isUpbit = false;
            }
            answer.Append(y);
        }
        if(isUpbit) {
            answer.Append(1);
        }

        // reversing
        string temp = answer.ToString();
        answer.Clear();
        for(int i=temp.Length - 1; i>= 0; i--) {
            answer.Append(temp[i]);
        }
        return answer.ToString();
    }
}