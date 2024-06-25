class Trie {
    class Node {
        boolean isEnd;
        char val;
        Map<Character, Node> nexts;
        Node(){
            nexts = new HashMap<>();
        }
        Node(char v) {
            this.val = v;
            nexts = new HashMap<>();
        }
        Node(char v, Map<Character, Node> n) {
            this.val = v;
            this.nexts = n;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        insertNode(word);
        
        // System.out.println("=======================");
        // printTrie(root, 0);
    }

    public void insertNode(String word) {
        Node ptr = root;
        Node temp;
        for(char c : word.toCharArray()) {
            if(!ptr.nexts.containsKey(c)) {
                temp = new Node(c);
                ptr.nexts.put(c, temp);
            }
            ptr = ptr.nexts.get(c);
        }
        ptr.isEnd = true;
    }
    

    public boolean search(String word) {
        
        Node ptr = root;
        for(char c : word.toCharArray()) {
            if(!ptr.nexts.containsKey(c)) {
                return false;
            }
            ptr = ptr.nexts.get(c);
        }
        return ptr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = root;
        for(char c : prefix.toCharArray()) {
            if(!ptr.nexts.containsKey(c)) {
                return false;
            }
            ptr = ptr.nexts.get(c);
        }
        return true;
    }

    private void printTrie(Node node, int depth) {
        if(node == null){
            return;
        }
        
        System.out.println(node.val + " d:" + depth);
        
        
        node.nexts.forEach((key, val) -> {
            printTrie(val, depth+1);
        });
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */