class WordDictionary {
    class Node{
        boolean isEnd;
        Node[] next;
        Node() {
            next = new Node['z'-'a'+1];
            isEnd = false;
        }
        
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node ptr = root;
        for(char c : word.toCharArray()) {
            if(ptr.next[c-'a'] == null) {
                ptr.next[c-'a'] = new Node();
            }
            ptr = ptr.next[c-'a'];
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node ptr = root;
        for(int idx=0; idx<word.length(); idx++) {
            char c = word.charAt(idx);
            if(c == '.') {
                String nextWord = word.substring(idx+1);
                for(Node p : ptr.next) {
                    if(p == null) {
                        continue;
                    }
                    
                    if(wildcardSearch(p, nextWord)) {
                        return true;
                    };
                }
                return false;
            }
            else if(ptr.next[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.next[c - 'a'];
        }
        return ptr.isEnd;
    }

    public boolean wildcardSearch(Node ptr, String word) {
        // word starts wildcard + 1
        for(int idx=0; idx<word.length(); idx++) {
            char c = word.charAt(idx);
            if(c == '.') {
                String nextWord = word.substring(idx+1);
                for(Node p : ptr.next) {
                    if(p == null) {
                        continue;
                    }
                    if(wildcardSearch(p, nextWord)) {
                        return true;
                    }
                }
                return false;
            }
            if(ptr.next[c - 'a'] == null) {
                return false;
            }
            
            ptr = ptr.next[c - 'a'];
        }
        return ptr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */