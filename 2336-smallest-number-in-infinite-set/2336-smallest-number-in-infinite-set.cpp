#include <queue>
#include <unordered_set>
class SmallestInfiniteSet {
private:
    const int max_val = 1000;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    unordered_set<int> min_set;
public:
    SmallestInfiniteSet() : min_heap(), min_set() {
        for(int i=1; i<=1000; i++) {
            min_heap.push(i);
            min_set.insert(i);
        }
    }
    
    int popSmallest() {
        if(min_heap.empty()) {
            return -1;
        }
        int num = min_heap.top();
        min_heap.pop();
        min_set.erase(num);
        return num;
    }
    
    void addBack(int num) {
        if(min_set.find(num) != min_set.end()) { // contains num
            return;
        }
        min_set.insert(num);
        min_heap.push(num);
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */