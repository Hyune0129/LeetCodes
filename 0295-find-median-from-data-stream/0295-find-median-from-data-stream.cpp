class MedianFinder {
private:
std::priority_queue<int> maxHeap;
std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(minHeap.size() == maxHeap.size()) {
            minHeap.push(num);
        } else {
            int num2 = minHeap.top();
            minHeap.pop();
            minHeap.push(std::max(num, num2));
            maxHeap.push(std::min(num, num2));
        }
    }
    
    double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double)( maxHeap.top() + minHeap.top() ) / 2;
        } else {
            return minHeap.top();
        }
        
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */