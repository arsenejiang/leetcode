public class WordDictionary {
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }
    
    private boolean helper(char[] word, int start, TrieNode root) {
        if (start == word.length) {
            return root.isWord;
        }
        
        if (word[start] == '.') {
            for(int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (helper(word, start + 1, root.children[i])) {
                        return true;
                    }
                }
            }
            
            return false;
        }
        else {
            if (root.children[c - 'a'] != null) {
                return helper(word, start + 1, root.children[c - 'a']);
            }
            else {
                return false;
            }
        }
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern"); 