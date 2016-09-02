class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    boolean isLeaf;
    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            
            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
            cur = cur.children[c-'a'];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            else {
                if (i == word.length() - 1) {
                    return cur.isLeaf;
                }
                cur = cur.childrens[c-'a'];
            }
        }
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            else {
                cur = cur.childrens[c-'a'];
            }
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");