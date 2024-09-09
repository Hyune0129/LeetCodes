// ref : https://leetcode.com/problems/max-points-on-a-line/solutions/5705349/beats-55-of-people

class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        if(points.size() <= 2) {
            return points.size();
        }
        int max = 0;
        int on_point = 0;
        for(int i=0; i<points.size(); i++) {
            for(int j=i+1; j<points.size(); j++) {
                on_point = 0;
                for(int k=0; k<points.size(); k++) {
                    // on_point if point[i], point[j] slope
                    int x1 = points[i][0];
                    int y1 = points[i][1];

                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    if((y1-y2) * (x2 - x3) == (y2-y3) * (x1-x2)) {
                        on_point++;
                    }
                }
                max = std::max(max, on_point);
            }
        }
        return max;
    }
};