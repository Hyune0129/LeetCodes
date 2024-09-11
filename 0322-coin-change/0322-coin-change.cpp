class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int* amounts = new int[amount + 1];
        for(int i=1; i<=amount; i++) {
            amounts[i] = -1;
        }
        amounts[0] = 0;
        for(int i=0; i<amount; i++) {
            if(amounts[i] == -1) {
                continue; // cant make i amount
            }
            for(int coin : coins) {
                if(coin > amount || coin + i > amount) {
                    continue;
                }
                if(amounts[i+coin] == -1) {
                    amounts[i + coin] = amounts[i] + 1;
                } else {
                    // std::cout << amounts[i+coin] << " " << amounts[i] << std::endl;
                    amounts[i + coin] = std::min(amounts[i+coin], amounts[i] + 1);
                }
                
            }
        }
        return amounts[amount];
    }
};