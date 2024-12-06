class Solution {
public:
    int numTilings(int n) {
        vector<long> arr(1001);
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        for(int i=4; i<=n; i++)
        {
            arr[i] = (arr[i-1] * 2 + arr[i - 3]) % 1000000007;
        }
        return arr[n];
    }
};