public class Solution {
    readonly List<char> VOWELS = new(){'a', 'e','i','o','u','A','E','I','O','U'};
    public string ReverseVowels(string s) {
        StringBuilder answer = new StringBuilder();
        int n = s.Length;
        int[] sIndexes = new int[n];
        int start = 0;
        int end = n-1;
        while(start < end) {
            //find vowel from left
            while(start <= end) {
                sIndexes[start] = start;
                if(isVowel(s[start])){
                    break;
                }
                start++;
            }

            // find vowel from right
            while(start <= end){
                sIndexes[end] = end;
                if(isVowel(s[end])) {
                    break;
                }
                end--;
            }
            if(start >= end) {
                break;
            }
            sIndexes[start] = end;
            sIndexes[end] = start;
            Console.WriteLine(start + " " +end);
            start++;
            end--;
            
        }
        for(int i=0; i<n; i++) {
            answer.Append(s[sIndexes[i]]);
        }
        return answer.ToString();
    }

    // private void swap(ref char a, ref char b) {
    //     char temp = a;
    //     a = b;
    //     b = temp;
    // }

    private bool isVowel(char c) {
        foreach (char vowel in VOWELS) {
            if(vowel == c) {
                return true;
            }
        }
        return false;
    }
}