class LRUCache {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node(int key, int val, Node pre ,Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
    Map<Integer, Node> cache;
    Node root;
    Node ptr;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        root = new Node(-1, -1);
        ptr = root;
    }

    public int get(int key) {
        Node n = cache.getOrDefault(key, null);
        if(n==null) {
            return -1;
        }
        removeNode(n);
        addLast(n);
        return n.val;
    }

    public void put(int key, int value) {
        if(cache.size() == capacity) {
            cache.remove(root.next.key);
            removeNode(root.next);
        }
        Node node = new Node(key, value);
        addLast(node);
        cache.put(key, node);
    }

    private void addLast(Node node){
        ptr.next = node;
        node.pre = ptr;
        node.next = null;
        ptr = ptr.next;
    }

    private void removeNode(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        if(nextNode == null) { // last node remove
            preNode.next = null;
            ptr = preNode;
            return;
        }
        preNode.next = nextNode;
        nextNode.pre = preNode;
        return;
    }

    private void printLinkedList(Node root) {
        
        for(Node node = root; node != null; node = node.next) {
            System.out.print(node.key + " " + node.val +" -> ");
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */