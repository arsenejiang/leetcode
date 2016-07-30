class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    // Initialize your data structure here.
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode r = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (r.children[c - 'a'] == null) {
                r.children[c - 'a'] = new TrieNode();
            }
            r = r.children[c - 'a'];
        }
        r.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode r = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (r.children[c - 'a'] == null) {
                return false;
            }
            r = r.children[c - 'a'];
        }
        
        return r.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode r = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = word.charAt(i);
            if (r.children[c - 'a'] == null) {
                return false;
            }
            r = r.children[c - 'a'];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");