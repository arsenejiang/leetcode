public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                helper(board, i, j, "", root, res);
            }
        }
        
        return res;
    }
    
    private void helper(char[][] board, int i, int j, String cur, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        String str = cur + c;
        if (node.isWord) {
            res.add(str);
            node.isWord = false; // de-dup
        }
        
        board[i][j] = '#';
        if (i > 0) {
            helper(board, i - 1, j, str, node, res);
        }
        if (i < board.length - 1) {
            helper(board, i + 1, j, str, node, res);
        }
        if (j > 0) {
            helper(board, i, j - 1, str, node, res);
        }
        if (j < board[0].length - 1) {
            helper(board, i, j + 1, str, node, res);
        }
        board[i][j] = c;
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        for(String w : words) {
            insertWord(root, w);
        }
    }
    
    private void insertWord(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        
        cur.isWord = true;
    }
    
    private boolean searchWord(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            
            cur = cur.children[word.charAt(i) - 'a'];
        }
        
        return cur.isWord;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}