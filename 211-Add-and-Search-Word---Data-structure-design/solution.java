public class WordDictionary {
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode r = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (r.children[c - 'a'] == null) {
                r.children[c - 'a'] = new TrieNode();
            }
            r = r.children[c - 'a'];
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
    
    private boolean search(char[] str, int index, TrieNode parent) {
        if (index == str.length) {
            return parent.isWord;
        }
        
        if (str[index] == '.') {
            for(int i = 0; i < 26; i++) {
                if (parent.children[i] != null) {
                    if (search(str, index + 1, parent.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            if (parent.children[c - str[index]] != null) {
                return search(str, index + 1, parent.child[c - str[index]]);
            }
            else {
                return false;
            }
        }
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");