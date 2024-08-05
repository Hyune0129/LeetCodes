public class Solution {
    public string PredictPartyVictory(string senate) {
        Queue<char> queue = new Queue<char>();
        int direCount = 0;
        int radiantCount = 0;
        int bannedDire = 0;
        int bannedRad = 0;
        foreach(char c in senate) {
            if(c == 'D') {
                direCount++;
            } else {
                radiantCount++;
            }
            queue.Enqueue(c);
        }
        while(queue.Count != 0) {
            char senator = queue.Dequeue();
            if(senator == 'R') {
                if(bannedRad > 0) {
                    bannedRad--;
                    radiantCount--;
                    continue;
                }
                if(direCount <= 0) { // Announce
                    return "Radiant";
                }
                bannedDire++;
                queue.Enqueue('R');
            } else { // D
                if(bannedDire > 0) { // ban
                    bannedDire--;
                    direCount--;
                    continue;
                }
                if(radiantCount <= 0) { // Announce
                    return "Dire";
                }
                bannedRad++;
                queue.Enqueue('D');
            }
        }
        return "error";
    }
}